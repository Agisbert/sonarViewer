/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.database.entity
 *	Class: Project.java
 *	Author: Alberto
 *	Last update: 22-mar-2016
 */

package org.w00tdevs.project.sonarviewer.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

/**
 * The Class Project.
 */
@Entity
@Table(name = "project")

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@ToString(includeFieldNames = true, of = { "projectId", "key", "name" })
public class Project {

	/** The project id. */
	@Id
	@Column
	private Long projectId;

	/** The key. */
	@Column
	private String key;

	/** The name. */
	@Column
	private String name;

	/** The issues. */
	@OneToMany(mappedBy = "project")
	List<Issue> issues;

	/** The profiles. */
	@ManyToMany(mappedBy = "projects")
	List<Profile> profiles;

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
	 * Gets the profiles.
	 *
	 * @return the profiles
	 */
	public List<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * Sets the profiles.
	 *
	 * @param profiles
	 *            the new profiles
	 */
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}
