/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerProject.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

/**
 * The Class SonarViewerProject.
 */
/**
 * @author Alberto
 *
 */
public class SonarViewerProject extends SonarViewerApiObject {

	/** The project id. */
	private Long projectId;

	/** The name. */
	private String name;

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId
	 *            the new project id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
