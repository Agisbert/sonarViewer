/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.domain
*	Class: SVProject.java
*	Author: Alberto
*	Last update: 01-abr-2016
*/

package org.w00tdevs.project.sonarviewer.domain;

import java.util.List;

import lombok.ToString;

/**
 * The Class Project.
 */

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@ToString(includeFieldNames = true, of = { "projectId", "key", "name" })
public class SVProject {

	/** The project id. */
	private Long projectId;

	/** The key. */
	private String key;

	/** The name. */
	private String name;

	/** The issues. */
	List<SVIssue> issues;

	/** The profiles. */
	List<SVProfile> profiles;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * Sets the id.
	 *
	 * @param projectId
	 *            the new id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the k.
	 *
	 * @return the k
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the k.
	 *
	 * @param key
	 *            the new k
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the nm.
	 *
	 * @return the nm
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the nm.
	 *
	 * @param name
	 *            the new nm
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the issues.
	 *
	 * @return the issues
	 */
	public List<SVIssue> getIssues() {
		return issues;
	}

	/**
	 * Sets the issues.
	 *
	 * @param issues
	 *            the new issues
	 */
	public void setIssues(List<SVIssue> issues) {
		this.issues = issues;
	}

	/**
	 * Gets the profiles.
	 *
	 * @return the profiles
	 */
	public List<SVProfile> getProfiles() {
		return profiles;
	}

	/**
	 * Sets the profiles.
	 *
	 * @param profiles
	 *            the new profiles
	 */
	public void setProfiles(List<SVProfile> profiles) {
		this.profiles = profiles;
	}

}
