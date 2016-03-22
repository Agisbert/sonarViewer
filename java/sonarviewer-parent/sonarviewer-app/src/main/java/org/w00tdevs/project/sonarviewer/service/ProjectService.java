/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service
*	Class: ProjectService.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.database.entity.Project;

/**
 * The Interface ProjectService.
 */
public interface ProjectService {

	/**
	 * Import project.
	 *
	 * @param projectText
	 *            the project text
	 * @return the list
	 */
	List<Project> importProjects(String projectText);

	/**
	 * Gets the available projects.
	 *
	 * @return the available projects
	 */
	List<Project> getAvailableProjects();

}
