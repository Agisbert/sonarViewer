/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.service
 *	Class: IssueService.java
 *	Author: Alberto
 *	Last update: 22-mar-2016
 */
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.database.entity.Issue;
import org.w00tdevs.project.sonarviewer.database.entity.Project;

/**
 * The Interface IssueService.
 */
public interface IssueService {

	/**
	 * Import issues from project.
	 *
	 * @param project
	 *            the project
	 * @return the list
	 */
	List<Issue> importIssuesFromProject(Project project);

}
