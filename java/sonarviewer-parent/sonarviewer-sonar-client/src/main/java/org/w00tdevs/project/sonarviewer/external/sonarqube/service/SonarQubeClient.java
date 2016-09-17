/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.external.sonarqube.service
*	Class: SonarQubeClient.java
*	Author: Alberto
*	Last update: 05-abr-2016
*/
package org.w00tdevs.project.sonarviewer.external.sonarqube.service;

import java.util.Date;
import java.util.List;

import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.IssuesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.ProfilesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.RulesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeProject;

/**
 * The Interface SonarQubeClient.
 */
public interface SonarQubeClient {

	/**
	 * Gets the issues.
	 *
	 * @param projectKey
	 *            the project key
	 * @param pageNumber
	 *            the page number
	 * @return the issues
	 */
	IssuesSearchResponse getIssues(String projectKey, Integer pageNumber);

	/**
	 * Gets the issues.
	 *
	 * @param projectKey
	 *            the project key
	 * @param author
	 *            the author
	 * @param pageNumber
	 *            the page number
	 * @return the issues
	 */
	IssuesSearchResponse getIssues(String projectKey, String author, Integer pageNumber);

	/**
	 * Gets the issues.
	 *
	 * @param projectKey
	 *            the project key
	 * @param pageNumber
	 *            the page number
	 * @param createdAfter
	 *            the created after
	 * @return the issues
	 */
	IssuesSearchResponse getIssues(String projectKey, Integer pageNumber, Date createdAfter);

	/**
	 * Gets the profiles.
	 *
	 * @param projectKey
	 *            the project key
	 * @return the profiles
	 */
	ProfilesSearchResponse getProfiles(String projectKey);

	/**
	 * Gets the rules.
	 *
	 * @param profileKey
	 *            the profile key
	 * @param activeIssues
	 *            the active issues
	 * @param pageNumber
	 *            the page number
	 * @return the rules
	 */
	RulesSearchResponse getRules(String profileKey, boolean activeIssues, Integer pageNumber);

	/**
	 * Gets the projects.
	 *
	 * @param projectText
	 *            the project text
	 * @return the projects
	 */
	List<SonarQubeProject> getProjects(String projectText);

}
