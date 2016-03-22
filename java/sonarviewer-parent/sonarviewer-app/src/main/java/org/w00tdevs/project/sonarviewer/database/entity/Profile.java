/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.database.entity
*	Class: Profile.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/

package org.w00tdevs.project.sonarviewer.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The Class Profile.
 */
@Entity
@Table(name = "profile")
public class Profile {

	/** The profile id. */
	@GenericGenerator(name = "profileNumericGenerator", strategy = "increment")
	@GeneratedValue(generator = "profileNumericGenerator")
	@Id
	@Column
	private Long profileId;

	/** The key. */
	@Column
	private String key;

	/** The name. */
	@Column
	private String name;

	/** The language. */
	@Column
	private String language;

	/** The language name. */
	@Column
	private String languageName;

	/** The is inherited. */
	@Column
	private Boolean isInherited;

	/** The projects. */
	@ManyToMany
	@JoinTable(name = "profileprojects", joinColumns = { @JoinColumn(name = "projectId") }, inverseJoinColumns = {
			@JoinColumn(name = "profileId") })
	List<Project> projects;

	/** The rules. */
	@OneToMany(mappedBy = "profile")
	List<Rule> rules;

	/**
	 * Gets the profile id.
	 *
	 * @return the profile id
	 */
	public Long getProfileId() {
		return profileId;
	}

	/**
	 * Sets the profile id.
	 *
	 * @param profileId
	 *            the new profile id
	 */
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *            the new key
	 */
	public void setKey(String key) {
		this.key = key;
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
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the language name.
	 *
	 * @return the language name
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * Sets the language name.
	 *
	 * @param languageName
	 *            the new language name
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	/**
	 * Gets the is inherited.
	 *
	 * @return the is inherited
	 */
	public Boolean getIsInherited() {
		return isInherited;
	}

	/**
	 * Sets the is inherited.
	 *
	 * @param isInherited
	 *            the new is inherited
	 */
	public void setIsInherited(Boolean isInherited) {
		this.isInherited = isInherited;
	}

	/**
	 * Gets the projects.
	 *
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * Sets the projects.
	 *
	 * @param projects
	 *            the new projects
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
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
