/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service
*	Class: RuleService.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.domain.SonarViewerRule;

/**
 * The Interface RuleService.
 */
public interface RuleService {

	/**
	 * Import rules from profile.
	 *
	 * @param profile
	 *            the profile
	 * @return the list
	 */
	List<Rule> importRulesFromProfile(Profile profile);

	/**
	 * Gets the sonar viewer rule list.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer rule list
	 */
	List<SonarViewerRule> getSonarViewerRuleList(Long projectId);

}
