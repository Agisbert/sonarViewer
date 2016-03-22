/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.domain
*	Class: SonarViewerTag.java
*	Author: Alberto
*	Last update: 11-mar-2016
*/
package org.w00tdevs.project.sonarviewer.domain;

import java.util.List;

/**
 * The Class Tag.
 */
public class SonarViewerTag {

	/** The tag id. */
	private Long tagId;

	/** The name. */
	private String name;

	/** The issues. */
	private List<SonarViewerIssue> issues;

}
