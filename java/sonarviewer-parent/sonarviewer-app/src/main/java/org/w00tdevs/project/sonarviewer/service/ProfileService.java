/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service
*	Class: ProfileService.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;

/**
 * The Interface ProfileService.
 */
public interface ProfileService {

	/**
	 * Import profiles from project.
	 *
	 * @param projectKey
	 *            the project key
	 * @return the long
	 */
	List<Profile> importProfilesFromProject(Project project);

}
