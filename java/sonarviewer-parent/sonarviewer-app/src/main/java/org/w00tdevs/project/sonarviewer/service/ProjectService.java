/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service
*	Class: ProjectService.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.domain.SVProject;

/**
 * The Interface ProjectService.
 */
public interface ProjectService {

	/**
	 * Import projects like.
	 *
	 * @param projectText the project text
	 * @return the list
	 */
	List<SVProject> importProjectsLike(String projectText);

	/**
	 * Gets the available projects in sonar like.
	 *
	 * @param projectText the project text
	 * @return the available projects in sonar like
	 */
	List<SVProject> getAvailableProjectsInSonarLike(String projectText);

	/**
	 * Exists project.
	 *
	 * @param project the project
	 * @return true, if successful
	 */
	boolean existsProject(String project);

	/**
	 * Gets the available projects.
	 *
	 * @return the available projects
	 */
	List<SVProject> getAvailableProjects();

	/**
	 * Gets the project.
	 *
	 * @param projectId the project id
	 * @return the project
	 */
	SVProject getProject(Long projectId);

}
