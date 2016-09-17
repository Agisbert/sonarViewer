/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.config
*	Class: ApplicationParams.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * The Class ApplicationParams.
 */
public final class ApplicationParams {

	/** The innitial project. */
	@Value("${sonar.viewer.innitialProject}")
	public String INNITIAL_PROJECT;

	/** The sonar server url. */
	@Value("${sonar.server.url}")
	public String SONAR_SERVER_URL;

}
