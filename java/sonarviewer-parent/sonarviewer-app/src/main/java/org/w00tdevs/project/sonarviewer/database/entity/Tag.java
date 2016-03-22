/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.entity
*	Class: Tag.java
*	Author: Alberto
*	Last update: 14-mar-2016
*/
package org.w00tdevs.project.sonarviewer.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class Tag.
 */
@Entity
@Table(name = "tag")
public class Tag {

	/** The tag id. */
	@Column
	private Long tagId;

	/** The name. */
	@Id
	@Column
	private String name;

	/** The issues. */
	@ManyToMany(mappedBy = "tags")
	private List<Issue> issues;

	/**
	 * Gets the tag id.
	 *
	 * @return the tag id
	 */
	public Long getTagId() {
		return tagId;
	}

	/**
	 * Sets the tag id.
	 *
	 * @param tagId
	 *            the new tag id
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
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

}
