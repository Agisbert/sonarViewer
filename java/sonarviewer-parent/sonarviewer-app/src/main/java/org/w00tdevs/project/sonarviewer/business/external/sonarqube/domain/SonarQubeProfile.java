/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain
*	Class: SonarQubeProfile.java
*	Author: Alberto
*	Last update: 17-mar-2016
*/

package org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class SonarQubeProfile.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "key", "name", "language", "languageName", "isInherited", "isDefault", "activeRuleCount",
		"rulesUpdatedAt" })
public class SonarQubeProfile {

	/** The key. */
	@JsonProperty("key")
	private String key;

	/** The name. */
	@JsonProperty("name")
	private String name;

	/** The language. */
	@JsonProperty("language")
	private String language;

	/** The language name. */
	@JsonProperty("languageName")
	private String languageName;

	/** The is inherited. */
	@JsonProperty("isInherited")
	private Boolean isInherited;

	/** The is default. */
	@JsonProperty("isDefault")
	private Boolean isDefault;

	/** The active rule count. */
	@JsonProperty("activeRuleCount")
	private Integer activeRuleCount;

	/** The rules updated at. */
	@JsonProperty("rulesUpdatedAt")
	private Date rulesUpdatedAt;

	/** The additional properties. */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *            the new key
	 */
	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language
	 *            the new language
	 */
	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the language name.
	 *
	 * @return the language name
	 */
	@JsonProperty("languageName")
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * Sets the language name.
	 *
	 * @param languageName
	 *            the new language name
	 */
	@JsonProperty("languageName")
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	/**
	 * Gets the is inherited.
	 *
	 * @return the is inherited
	 */
	@JsonProperty("isInherited")
	public Boolean getIsInherited() {
		return isInherited;
	}

	/**
	 * Sets the is inherited.
	 *
	 * @param isInherited
	 *            the new is inherited
	 */
	@JsonProperty("isInherited")
	public void setIsInherited(Boolean isInherited) {
		this.isInherited = isInherited;
	}

	/**
	 * Gets the is default.
	 *
	 * @return the is default
	 */
	@JsonProperty("isDefault")
	public Boolean getIsDefault() {
		return isDefault;
	}

	/**
	 * Sets the is default.
	 *
	 * @param isDefault
	 *            the new is default
	 */
	@JsonProperty("isDefault")
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * Gets the active rule count.
	 *
	 * @return the active rule count
	 */
	@JsonProperty("activeRuleCount")
	public Integer getActiveRuleCount() {
		return activeRuleCount;
	}

	/**
	 * Sets the active rule count.
	 *
	 * @param activeRuleCount
	 *            the new active rule count
	 */
	@JsonProperty("activeRuleCount")
	public void setActiveRuleCount(Integer activeRuleCount) {
		this.activeRuleCount = activeRuleCount;
	}

	/**
	 * Gets the rules updated at.
	 *
	 * @return the rules updated at
	 */
	@JsonProperty("rulesUpdatedAt")
	public Date getRulesUpdatedAt() {
		return rulesUpdatedAt;
	}

	/**
	 * Sets the rules updated at.
	 *
	 * @param rulesUpdatedAt
	 *            the new rules updated at
	 */
	@JsonProperty("rulesUpdatedAt")
	public void setRulesUpdatedAt(Date rulesUpdatedAt) {
		this.rulesUpdatedAt = rulesUpdatedAt;
	}

	/**
	 * Gets the additional properties.
	 *
	 * @return the additional properties
	 */
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * Sets the additional property.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
