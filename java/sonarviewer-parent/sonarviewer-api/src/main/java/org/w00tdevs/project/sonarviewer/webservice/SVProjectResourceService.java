/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVProjectResourceService.java
*	Author: Alberto
*	Last update: 05-jul-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerProject;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerQProfile;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;

/**
 * The Interface SVProjectResourceService.
 */
@Path("projects")
public interface SVProjectResourceService {

	/**
	 * Gets the sonar viewer projects.
	 *
	 * @return the sonar viewer projects
	 */
	@GET
	@Produces("application/json")
	List<SonarViewerProject> getSonarViewerProjects();

	/**
	 * Gets the sonar viewer project.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project
	 */
	@Path("{projectId}")
	@GET
	SonarViewerProject getSonarViewerProject(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project profiles.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project profiles
	 */
	@Path("{projectId}/profiles")
	@GET
	List<SonarViewerQProfile> getSonarViewerProjectProfiles(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project rules.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project rules
	 */
	@Path("projects/{projectId}/rules")
	@GET
	List<SonarViewerRule> getSonarViewerProjectRules(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project issues.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project issues
	 */
	@Path("projects/{projectId}/issues")
	@GET
	List<SonarViewerIssue> getSonarViewerProjectIssues(@PathParam("projectId") Long projectId);

}
