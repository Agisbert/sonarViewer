/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.domain
*	Class: SVTag.java
*	Author: Alberto
*	Last update: 01-abr-2016
*/
package org.w00tdevs.project.sonarviewer.domain;

import java.util.List;

/**
 * The Class Tag.
 */
public class SVTag {

	/** The name. */
	private String name;

	/** The issues. */
	private List<SVIssue> issues;

	/** The rules. */
	private List<SVRule> rules;

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
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	public List<SVRule> getRules() {
		return rules;
	}

	/**
	 * Sets the rules.
	 *
	 * @param rules
	 *            the new rules
	 */
	public void setRules(List<SVRule> rules) {
		this.rules = rules;
	}

}
