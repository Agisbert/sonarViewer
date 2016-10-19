/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service.impl
*	Class: RuleServiceImpl.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.database.dao.ProjectRepository;
import org.w00tdevs.project.sonarviewer.database.dao.RuleRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.RulesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeRule;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.RuleService;

/**
 * The Class RuleServiceImpl.
 */
@Service
@Transactional
public class RuleServiceImpl implements RuleService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(RuleServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The profile service. */
	@Autowired
	private ProfileService profileService;

	/** The rule respository. */
	@Autowired
	private RuleRepository ruleRespository;

	/** The project repository. */
	@Autowired
	private ProjectRepository projectRepository;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	/**
	 * Import rules from profile.
	 *
	 * @param svProfile
	 *            the sv profile
	 * @return the list
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * importRulesFromProfile(java.lang.String)
	 */
	@Override
	public List<SVRule> importRulesFromProfile(SVProfile svProfile) {
		// Retrieve first list of rules
		LOG.info("Importing RULES from Q Profile " + svProfile);
		RulesSearchResponse rsResponse = sonarQubeClient.getRules(svProfile.getKey(), true, 1);
		// Innitialize the list with the first pack of rules
		List<SonarQubeRule> sonarQubeRules = rsResponse.getRules();
		// Iterate the pages
		// for (int i = 1; i < rsResponse.getNumberOfPages(); i++) {
		// RulesSearchResponse rsResponseAux =
		// sonarQubeClient.getRules(svProfile.getKey(), true, i + 1);
		// // Populate the list with the following list of rules
		// rules.addAll(rsResponseAux.getRules());
		// }

		// Super FAST implementation with streams
		sonarQubeRules.addAll(IntStream.range(1, rsResponse.getNumberOfPages() - 1).parallel().mapToObj(i -> {
			LOG.info("Importing page " + (i + 1) + " of " + rsResponse.getNumberOfPages() + " from Profile "
					+ svProfile);
			return sonarQubeClient.getRules(svProfile.getKey(), true, i + 1);
		}).flatMap(p -> p.getRules().stream()).collect(Collectors.toList()));

		LOG.info("Retrieved " + sonarQubeRules.size() + " RULES from Q Profile " + svProfile);
		// Convert it to db entities
		List<Rule> rulesEntities = listTransformer.transform(sonarQubeRules, Rule.class);
		// Save the rule if exists
		List<Rule> savedRules = saveRulesIfNotExists(rulesEntities, dozerMapper.map(svProfile, Profile.class));
		LOG.info("Saved " + savedRules.size() + " RULES from Q Profile " + svProfile);
		List<SVRule> savedSVRules = listTransformer.transform(savedRules, SVRule.class);
		return savedSVRules;
	}

	/**
	 * Save rules if not exists.
	 *
	 * @param rules
	 *            the rules
	 * @param profile
	 *            the profile
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

	/**
	 * Gets the available rules.
	 *
	 * @return the available rules
	 */
	@Override
	public List<SVRule> getAvailableRules() {
		List<Rule> rules = (List<Rule>) ruleRespository.findAll();
		return listTransformer.transform(rules, SVRule.class);
	}

	/**
	 * Gets the rules from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the rules from project
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * getSonarViewerRuleList(java.lang.String)
	 */
	@Override
	public List<SVRule> getRulesFromProject(SVProject svProject) {
		List<SVProfile> svProfiles = profileService.getProfilesFromProject(svProject);
		List<SVRule> svRules = new ArrayList<SVRule>();
		for (SVProfile svProfile : svProfiles) {
			// Collect al the rules
			svRules.addAll(this.getRulesFromProfile(svProfile));
		}
		return svRules;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * importRulesFromProject(org.w00tdevs.project.sonarviewer.domain.SVProject)
	 */
	@Override
	public List<SVRule> importRulesFromProject(SVProject svProject) {
		List<SVProfile> svProfiles = profileService.getProfilesFromProject(svProject);
		List<SVRule> svRules = new ArrayList<SVRule>();
		for (SVProfile svProfile : svProfiles) {
			svRules.addAll(importRulesFromProfile(svProfile));
		}
		return svRules;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.service.RuleService#getRulesFromProfile(
	 * org.w00tdevs.project.sonarviewer.domain.SVProfile)
	 */
	@Override
	public List<SVRule> getRulesFromProfile(SVProfile svProfile) {
		Profile profile = dozerMapper.map(svProfile, Profile.class);
		List<Rule> rules = ruleRespository.findByProfile(profile);
		// Transform it into domain
		List<SVRule> svRules = listTransformer.transform(rules, SVRule.class);
		return svRules;
	}

	@Override
	public SVRule getRule(Long ruleId) {
		Rule rule = ruleRespository.findOne(ruleId);
		return dozerMapper.map(rule, SVRule.class);
	}

}
