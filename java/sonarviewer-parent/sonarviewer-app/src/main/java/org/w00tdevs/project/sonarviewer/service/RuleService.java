/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service
*	Class: RuleService.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;

/**
 * The Interface RuleService.
 */
public interface RuleService {

	/**
	 * Import rules from profile.
	 *
	 * @param svProfile
	 *            the sv profile
	 * @return the list
	 */
	List<SVRule> importRulesFromProfile(SVProfile svProfile);

	/**
	 * Import rules from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the list
	 */
	List<SVRule> importRulesFromProject(SVProject svProject);

	/**
	 * Gets the rules from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the rules from project
	 */
	List<SVRule> getRulesFromProject(SVProject svProject);

	/**
	 * Gets the rules from profile.
	 *
	 * @param svProfile
	 *            the sv profile
	 * @return the rules from profile
	 */
	List<SVRule> getRulesFromProfile(SVProfile svProfile);

	/**
	 * Gets the rule.
	 *
	 * @param ruleId
	 *            the rule id
	 * @return the rule
	 */
	SVRule getRule(Long ruleId);

}
