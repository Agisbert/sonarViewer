/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service
*	Class: IssueService.java
*	Author: Alberto
*	Last update: 16-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.service;

/**
 * The Interface IssueService.
 */
public interface IssueService {

	/**
	 * Import issues for project.
	 *
	 * @param projectKey
	 *            the project key
	 * @return the long
	 */
	Long importIssuesFromProject(String projectKey);

}
