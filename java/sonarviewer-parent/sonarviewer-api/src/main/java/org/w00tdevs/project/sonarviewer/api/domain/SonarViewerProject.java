/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerProject.java
*	Author: Alberto
*	Last update: 06-jul-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

/**
 * The Class SonarViewerTag.
 */
/**
 * @author Alberto
 *
 */
public class SonarViewerProject {

	/** The project id. */
	private Long projectId;

	/** The name. */
	private String name;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
