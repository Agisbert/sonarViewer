/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.domain
*	Class: SVProfile.java
*	Author: Alberto
*	Last update: 01-abr-2016
*/

package org.w00tdevs.project.sonarviewer.domain;

import java.util.List;

import lombok.ToString;

/**
 * The Class Profile.
 */
@ToString(includeFieldNames = true, of = { "profileId", "key", "name" })
public class SVProfile {

	/** The profile id. */
	private Long profileId;

	/** The key. */
	private String key;

	/** The name. */
	private String name;

	/** The language. */
	private String language;

	/** The language name. */
	private String languageName;

	/** The is inherited. */
	private Boolean isInherited;

	/** The projects. */
	List<SVProject> projects;

	/** The rules. */
	List<SVRule> rules;

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
	public List<SVProject> getProjects() {
		return projects;
	}

	/**
	 * Sets the projects.
	 *
	 * @param projects
	 *            the new projects
	 */
	public void setProjects(List<SVProject> projects) {
		this.projects = projects;
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
