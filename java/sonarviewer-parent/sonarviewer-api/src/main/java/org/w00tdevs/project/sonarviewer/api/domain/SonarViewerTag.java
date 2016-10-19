/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerTag.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

/**
 * The Class SonarViewerTag.
 */
public class SonarViewerTag extends SonarViewerApiResource {

	/** The name. */
	private String name;

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
