/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVProjectResourceService.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerProject;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerQProfile;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;

/**
 * The Interface SVProjectResourceService.
 */
@Path("projects")
@Produces("application/json")
public interface SVProjectResourceService {

	/**
	 * Gets the sonar viewer projects.
	 *
	 * @return the sonar viewer projects
	 */
	@GET
	List<SonarViewerProject> getSonarViewerProjects();

	/**
	 * Gets the sonar viewer projects count.
	 *
	 * @return the sonar viewer projects count
	 */
	@Path("summary")
	@GET
	List<SonarViewerMetadata> getSonarViewerProjectsSumary();

	/**
	 * Gets the sonar viewer projects count.
	 *
	 * @return the sonar viewer projects count
	 */
	@Path("count")
	@GET
	SonarViewerCountMetadata getSonarViewerProjectsCount();

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
	 * Gets the sonar viewer project profiles count.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project profiles count
	 */
	@Path("{projectId}/profiles/count")
	@GET
	SonarViewerCountMetadata getSonarViewerProjectProfilesCount(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project rules.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project rules
	 */
	@Path("{projectId}/rules")
	@GET
	List<SonarViewerRule> getSonarViewerProjectRules(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project rules.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project rules
	 */
	@Path("{projectId}/rules/count")
	@GET
	SonarViewerCountMetadata getSonarViewerProjectRulesCount(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project issues.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project issues
	 */
	@Path("{projectId}/issues")
	@GET
	List<SonarViewerIssue> getSonarViewerProjectIssues(@PathParam("projectId") Long projectId);

	/**
	 * Gets the sonar viewer project issues.
	 *
	 * @param projectId
	 *            the project id
	 * @return the sonar viewer project issues
	 */
	@Path("{projectId}/issues/count")
	@GET
	SonarViewerCountMetadata getSonarViewerProjectIssuesCount(@PathParam("projectId") Long projectId);

}
