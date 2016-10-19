/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVProfileResourceService.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerQProfile;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;

/**
 * The Interface SVProfileResourceService.
 */
@Path("profiles")
public interface SVProfileResourceService {

	/**
	 * Gets the sonar viewer profile.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the sonar viewer profile
	 */
	@Path("counts")
	@GET
	SonarViewerCountMetadata getSonarViewerProfileCount();

	/**
	 * Gets the sonar viewer profile.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the sonar viewer profile
	 */
	@Path("{profileId}")
	@GET
	SonarViewerQProfile getSonarViewerProfile(@PathParam("profileId") Long profileId);

	/**
	 * Gets the sonar viewer profile rules.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the sonar viewer profile rules
	 */
	@Path("{profileId}/rules")
	@GET
	List<SonarViewerRule> getSonarViewerProfileRules(@PathParam("profileId") Long profileId);

	/**
	 * Gets the sonar viewer profile rules count.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the sonar viewer profile rules count
	 */
	@Path("{profileId}/rules/count")
	@GET
	SonarViewerCountMetadata getSonarViewerProfileRulesCount(@PathParam("profileId") Long profileId);

	/**
	 * Gets the sonar viewer profile issues.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the sonar viewer profile issues
	 */
	@Path("{profileId}/issues")
	@GET
	List<SonarViewerIssue> getSonarViewerProfileIssues(@PathParam("profileId") Long profileId);

	/**
	 * Gets the sonar viewer profile issues count.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the sonar viewer profile issues count
	 */
	@Path("{profileId}/issues")
	@GET
	SonarViewerCountMetadata getSonarViewerProfileIssuesCount(@PathParam("profileId") Long profileId);
}
