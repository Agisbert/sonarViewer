/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVRuleResourceService.java
*	Author: Alberto
*	Last update: 30-sep-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;

/**
 * The Interface SVRuleResourceService.
 */
@Path("rules")
public interface SVRuleResourceService {

	/**
	 * Gets the sonar viewer rules count.
	 *
	 * @return the sonar viewer rules count
	 */
	@Path("count")
	@GET
	SonarViewerCountMetadata getSonarViewerRulesCount();

	/**
	 * Gets the sonar viewer rule.
	 *
	 * @param ruleId
	 *            the rule id
	 * @return the sonar viewer rule
	 */
	@Path("{ruleId}")
	@GET
	SonarViewerRule getSonarViewerRule(@PathParam("ruleId") Long ruleId);

	/**
	 * Gets the sonar viewer rule issues.
	 *
	 * @param ruleId
	 *            the rule id
	 * @return the sonar viewer rule issues
	 */
	@Path("{ruleId}/issues")
	@GET
	List<SonarViewerIssue> getSonarViewerRuleIssues(@PathParam("ruleId") Long ruleId);

	/**
	 * Gets the sonar viewer rule issues count.
	 *
	 * @param ruleId
	 *            the rule id
	 * @return the sonar viewer rule issues count
	 */
	@Path("{ruleId}/issues/count")
	@GET
	SonarViewerCountMetadata getSonarViewerRuleIssuesCount(@PathParam("ruleId") Long ruleId);

}
