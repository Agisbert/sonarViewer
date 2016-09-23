/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerQProfile.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

/**
 * The Class SonarViewerQProfile.
 */
public class SonarViewerQProfile extends SonarViewerApiObject {

	/** The profile id. */
	private Long profileId;

	/** The name. */
	private String name;

	/**
	 * Gets the profile id.
	 *
	 * @return the profile id
	 */
	public Long getProfileId() {
		return profileId;
	}

	/**
	 * Sets the profile id.
	 *
	 * @param profileId
	 *            the new profile id
	 */
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
