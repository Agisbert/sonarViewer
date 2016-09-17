/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVRuleResourceService.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;

/**
 * The Interface SVRuleResourceService.
 */
@Path("rules")
public interface SVRuleResourceService {

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

}
