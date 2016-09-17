/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service
*	Class: ProfileService.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.service;

import java.util.List;

import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;

/**
 * The Interface ProfileService.
 */
public interface ProfileService {

	/**
	 * Gets the profile.
	 *
	 * @param profileId
	 *            the profile id
	 * @return the profile
	 */
	SVProfile getProfile(Long profileId);

	/**
	 * Import profiles from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the list
	 */
	List<SVProfile> importProfilesFromProject(SVProject svProject);

	/**
	 * Gets the profiles from project.
	 *
	 * @param svProject
	 *            the sv project
	 * @return the profiles from project
	 */
	List<SVProfile> getProfilesFromProject(SVProject svProject);

}
