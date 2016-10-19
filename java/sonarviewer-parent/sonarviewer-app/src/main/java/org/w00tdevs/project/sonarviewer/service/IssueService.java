/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service
*	Class: IssueService.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.Date;
import java.util.List;

import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;

/**
 * The Interface IssueService.
 */
/**
 * @author Alberto
 *
 */
public interface IssueService {

	/**
	 * Import issues from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the list
	 */
	List<SVIssue> importIssuesFromProject(SVProject svProject);

	/**
	 * Import issues from project since date.
	 *
	 * @param svProject
	 *            the sv project
	 * @param date
	 *            the date
	 * @return the list
	 */
	List<SVIssue> importIssuesFromProjectSinceDate(SVProject svProject, Date date);

	/**
	 * Gets the last creation date from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the last creation date from project
	 */
	Date getLastCreationDateFromProject(SVProject svProject);

	/**
	 * Gets the issues from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the issues from project
	 */
	List<SVIssue> getIssuesFromProject(SVProject svProject);

	/**
	 * Gets the issues from project and profile.
	 *
	 * @param svProject
	 *            the sv project
	 * @param svProfile
	 *            the sv profile
	 * @return the issues from project and profile
	 */
	List<SVIssue> getIssuesFromProjectAndProfile(SVProject svProject, SVProfile svProfile);

	/**
	 * Gets the issues from project and rule.
	 *
	 * @param svProject
	 *            the sv project
	 * @param svRule
	 *            the sv rule
	 * @return the issues from project and rule
	 */
	List<SVIssue> getIssuesFromProjectAndRule(SVProject svProject, SVRule svRule);

	/**
	 * Gets the issue.
	 *
	 * @param issueId
	 *            the issue id
	 * @return the issue
	 */
	SVIssue getIssue(Long issueId);

	/**
	 * Gets the issues from profile.
	 *
	 * @param svProfile
	 *            the sv profile
	 * @return the issues from profile
	 */
	List<SVIssue> getIssuesFromProfile(SVProfile svProfile);

	/**
	 * Gets the available issues.
	 *
	 * @return the available issues
	 */
	List<SVIssue> getAvailableIssues();

	/**
	 * Gets the issues from rule.
	 *
	 * @param svRule
	 *            the sv rule
	 * @return the issues from rule
	 */
	List<SVIssue> getIssuesFromRule(SVRule svRule);

}
