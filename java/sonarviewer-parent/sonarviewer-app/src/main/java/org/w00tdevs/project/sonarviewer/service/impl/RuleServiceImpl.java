/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service.impl
*	Class: RuleServiceImpl.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.database.dao.ProfileRepository;
import org.w00tdevs.project.sonarviewer.database.dao.ProjectRepository;
import org.w00tdevs.project.sonarviewer.database.dao.RuleRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.RulesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeRule;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.RuleService;

/**
 * The Class RuleServiceImpl.
 */
@Transactional
@Service
public class RuleServiceImpl implements RuleService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(RuleServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The rule respository. */
	@Autowired
	private RuleRepository ruleRespository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ProjectRepository projectRepository;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * importRulesFromProfile(java.lang.String)
	 */
	@Override
	public List<Rule> importRulesFromProfile(Profile profile) {
		// Retrieve first list of rules
		LOG.info("Importing RULES from Q Profile " + profile);
		RulesSearchResponse rsResponse = sonarQubeClient.getRules(profile.getKey(), true, 1);
		// Innitialize the list with the first pack of rules
		List<SonarQubeRule> rules = rsResponse.getRules();
		// Iterate the pages
		for (int i = 0; i < rsResponse.getNumberOfPages(); i++) {
			RulesSearchResponse rsResponseAux = sonarQubeClient.getRules(profile.getKey(), true, i + 1);
			// Populate the list with the following list of rules
			rules.addAll(rsResponseAux.getRules());
		}
		LOG.info("Retrieved " + rules.size() + " RULES from Q Profile " + profile);
		// Convert it to db entities
		List<Rule> rulesEntities = listTransformer.transform(rules, Rule.class);
		// Save the rule if exists
		List<Rule> savedRules = saveRulesIfNotExists(rulesEntities, profile);
		LOG.info("Saved " + savedRules.size() + " RULES from Q Profile " + profile);
		// return the size of imported rules.
		return savedRules;
	}

	/**
	 * Save rules if not exists.
	 *
	 * @param rules
	 *            the rules
	 * @return the list
	 */
	private List<Rule> saveRulesIfNotExists(List<Rule> rules, Profile profile) {
		List<Rule> savedRules = new ArrayList<Rule>();
		for (Rule rule : rules) {
			Rule savedRule = ruleRespository.findOneByKey(rule.getKey());
			if (savedRule == null) {
				// Set the already saved profile.
				rule.setProfile(profile);
				savedRules.add(ruleRespository.save(rule));
			}
		}
		return savedRules;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * getSonarViewerRuleList(java.lang.String)
	 */
	@Override
	public List<SonarViewerRule> getSonarViewerRuleList(Long projectId) {
		// Retrieve the project by its ID
		Project project = projectRepository.findOne(projectId);
		// Get profiles which finally contain the rules.
		List<Profile> profiles = project.getProfiles();
		List<Rule> rules = new ArrayList<Rule>();
		for (Profile profile : profiles) {
			// Collect al the rules
			rules.addAll(profile.getRules());
		}
		// Transform it into SonarViewerRules
		List<SonarViewerRule> sonarViewerRules = listTransformer.transform(rules, SonarViewerRule.class);
		return sonarViewerRules;
	}

}
