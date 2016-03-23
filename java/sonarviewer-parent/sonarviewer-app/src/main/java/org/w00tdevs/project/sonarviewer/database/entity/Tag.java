/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.entity
*	Class: Tag.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.ToString;

/**
 * The Class Tag.
 */
@Entity
@Table(name = "tag")
@ToString(includeFieldNames = true, of = { "name" })
public class Tag {

	/** The name. */
	@Id
	@Column
	private String name;

	/** The issues. */
	@ManyToMany(mappedBy = "tags")
	private List<Issue> issues;

	/** The rules. */
	@ManyToMany(mappedBy = "tags")
	private List<Rule> rules;

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
	public List<Issue> getIssues() {
		return issues;
	}

	/**
	 * Sets the issues.
	 *
	 * @param issues
	 *            the new issues
	 */
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	/**
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	public List<Rule> getRules() {
		return rules;
	}

	/**
	 * Sets the rules.
	 *
	 * @param rules
	 *            the new rules
	 */
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

}
