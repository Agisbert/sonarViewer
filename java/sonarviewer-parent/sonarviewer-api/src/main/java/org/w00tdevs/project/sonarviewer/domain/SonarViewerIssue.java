/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.domain
*	Class: SonarViewerIssue.java
*	Author: Alberto
*	Last update: 11-mar-2016
*/

package org.w00tdevs.project.sonarviewer.domain;

import java.util.Date;
import java.util.List;

/**
 * The Class Issue.
 */
public class SonarViewerIssue {

	/** The issue id. */
	private Long issueId;

	/** The key. */
	private String key;

	/** The rule. */
	private SonarViewerRule rule;

	/** The severity. */
	private String severity;

	/** The component. */
	private String component;

	/** The component id. */
	private Integer componentId;

	/** The project. */
	private String project;

	/** The line. */
	private Integer line;

	/** The status. */
	private String status;

	/** The message. */
	private String message;

	/** The debt. */
	private String debt;

	/** The author. */
	private String author;

	/** The tags. */
	private List<SonarViewerTag> tags;

	/** The creation date. */
	private Date creationDate;

	/** The update date. */
	private Date updateDate;

}
