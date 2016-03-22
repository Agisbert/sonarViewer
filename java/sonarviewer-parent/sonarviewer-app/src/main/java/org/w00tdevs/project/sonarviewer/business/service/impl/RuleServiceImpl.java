/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service.impl
*	Class: RuleServiceImpl.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.business.database.dao.RuleRepository;
import org.w00tdevs.project.sonarviewer.business.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.RulesSearchResponse;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.SonarQubeRule;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.business.service.RuleService;
import org.w00tdevs.project.sonarviewer.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;

/**
 * The Class RuleServiceImpl.
 */
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
	public List<Rule> importRulesFromProfile(String profileKey) {
		// Retrieve first list of rules
		LOG.info("Importing RULES from Q Profile " + profileKey);
		RulesSearchResponse rsResponse = sonarQubeClient.getRules(profileKey, true, 1);
		// Innitialize the list with the first pack of rules
		List<SonarQubeRule> rules = rsResponse.getRules();
		// Iterate the pages
		for (int i = 0; i < rsResponse.getNumberOfPages(); i++) {
			RulesSearchResponse rsResponseAux = sonarQubeClient.getRules(profileKey, true, i + 1);
			// Populate the list with the following list of rules
			rules.addAll(rsResponseAux.getRules());
		}
		LOG.info("Retrieved " + rules.size() + " RULES from Q Profile " + profileKey);
		// Convert it to db entities
		List<Rule> rulesEntities = listTransformer.transform(rules, Rule.class);
		// Save the rule if exists
		List<Rule> savedRules = IteratorUtils.toList(saveRulesIfNotExists(rulesEntities).iterator());
		LOG.info("Saved " + savedRules.size() + " RULES from Q Profile " + profileKey);
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
	private List<Rule> saveRulesIfNotExists(List<Rule> rules) {
		List<Rule> savedRules = new ArrayList<Rule>();
		for (Rule rule : rules) {
			Rule savedRule = ruleRespository.findOneByKey(rule.getKey());
			if (savedRule == null) {
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
	public List<SonarViewerRule> getSonarViewerRuleList(String projectKey) {
		List<Rule> rules = null;
		List<SonarViewerRule> sonarViewerRules = listTransformer.transform(rules, SonarViewerRule.class);
		return sonarViewerRules;
	}

}
