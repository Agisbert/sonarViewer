/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.external.sonarqube.domain
*	Class: SonarQubeRule.java
*	Author: Alberto
*	Last update: 23-mar-2016
*/

package org.w00tdevs.project.sonarviewer.external.sonarqube.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;

/**
 * The Class Rule.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "key", "repo", "name", "createdAt", "htmlDesc", "severity", "status", "internalKey", "isTemplate",
		"tags", "sysTags", "lang", "langName", "params", "defaultDebtChar", "defaultDebtSubChar",
		"defaultDebtRemFnType", "defaultDebtRemFnOffset", "debtOverloaded", "debtRemFnType", "debtRemFnOffset" })
@ToString(includeFieldNames = true, of = { "key", "name" })
public class SonarQubeRule {

	/** The key. */
	@JsonProperty("key")
	private String key;

	/** The repo. */
	@JsonProperty("repo")
	private String repo;

	/** The name. */
	@JsonProperty("name")
	private String name;

	/** The created at. */
	@JsonProperty("createdAt")
	private Date createdAt;

	/** The html desc. */
	@JsonProperty("htmlDesc")
	private String htmlDesc;

	/** The severity. */
	@JsonProperty("severity")
	private String severity;

	/** The status. */
	@JsonProperty("status")
	private String status;

	/** The internal key. */
	@JsonProperty("internalKey")
	private String internalKey;

	/** The is template. */
	@JsonProperty("isTemplate")
	private Boolean isTemplate;

	/** The tags. */
	@JsonProperty("tags")
	private List<String> tags = new ArrayList<String>();

	/** The sys tags. */
	@JsonProperty("sysTags")
	private List<String> sysTags = new ArrayList<String>();

	/** The lang. */
	@JsonProperty("lang")
	private String lang;

	/** The lang name. */
	@JsonProperty("langName")
	private String langName;

	/** The params. */
	@JsonProperty("params")
	private List<Object> params = new ArrayList<Object>();

	/** The default debt char. */
	@JsonProperty("defaultDebtChar")
	private String defaultDebtChar;

	/** The default debt sub char. */
	@JsonProperty("defaultDebtSubChar")
	private String defaultDebtSubChar;

	/** The default debt rem fn type. */
	@JsonProperty("defaultDebtRemFnType")
	private String defaultDebtRemFnType;

	/** The default debt rem fn offset. */
	@JsonProperty("defaultDebtRemFnOffset")
	private String defaultDebtRemFnOffset;

	/** The debt overloaded. */
	@JsonProperty("debtOverloaded")
	private Boolean debtOverloaded;

	/** The debt rem fn type. */
	@JsonProperty("debtRemFnType")
	private String debtRemFnType;

	/** The debt rem fn offset. */
	@JsonProperty("debtRemFnOffset")
	private String debtRemFnOffset;

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
	 * Gets the repo.
	 *
	 * @return the repo
	 */
	@JsonProperty("repo")
	public String getRepo() {
		return repo;
	}

	/**
	 * Sets the repo.
	 *
	 * @param repo
	 *            the new repo
	 */
	@JsonProperty("repo")
	public void setRepo(String repo) {
		this.repo = repo;
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
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	@JsonProperty("createdAt")
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt
	 *            the new created at
	 */
	@JsonProperty("createdAt")
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the html desc.
	 *
	 * @return the html desc
	 */
	@JsonProperty("htmlDesc")
	public String getHtmlDesc() {
		return htmlDesc;
	}

	/**
	 * Sets the html desc.
	 *
	 * @param htmlDesc
	 *            the new html desc
	 */
	@JsonProperty("htmlDesc")
	public void setHtmlDesc(String htmlDesc) {
		this.htmlDesc = htmlDesc;
	}

	/**
	 * Gets the severity.
	 *
	 * @return the severity
	 */
	@JsonProperty("severity")
	public String getSeverity() {
		return severity;
	}

	/**
	 * Sets the severity.
	 *
	 * @param severity
	 *            the new severity
	 */
	@JsonProperty("severity")
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the internal key.
	 *
	 * @return the internal key
	 */
	@JsonProperty("internalKey")
	public String getInternalKey() {
		return internalKey;
	}

	/**
	 * Sets the internal key.
	 *
	 * @param internalKey
	 *            the new internal key
	 */
	@JsonProperty("internalKey")
	public void setInternalKey(String internalKey) {
		this.internalKey = internalKey;
	}

	/**
	 * Gets the checks if is template.
	 *
	 * @return the checks if is template
	 */
	@JsonProperty("isTemplate")
	public Boolean getIsTemplate() {
		return isTemplate;
	}

	/**
	 * Sets the checks if is template.
	 *
	 * @param isTemplate
	 *            the new checks if is template
	 */
	@JsonProperty("isTemplate")
	public void setIsTemplate(Boolean isTemplate) {
		this.isTemplate = isTemplate;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	@JsonProperty("tags")
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags
	 *            the new tags
	 */
	@JsonProperty("tags")
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Gets the sys tags.
	 *
	 * @return the sys tags
	 */
	@JsonProperty("sysTags")
	public List<String> getSysTags() {
		return sysTags;
	}

	/**
	 * Sets the sys tags.
	 *
	 * @param sysTags
	 *            the new sys tags
	 */
	@JsonProperty("sysTags")
	public void setSysTags(List<String> sysTags) {
		this.sysTags = sysTags;
	}

	/**
	 * Gets the lang.
	 *
	 * @return the lang
	 */
	@JsonProperty("lang")
	public String getLang() {
		return lang;
	}

	/**
	 * Sets the lang.
	 *
	 * @param lang
	 *            the new lang
	 */
	@JsonProperty("lang")
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * Gets the lang name.
	 *
	 * @return the lang name
	 */
	@JsonProperty("langName")
	public String getLangName() {
		return langName;
	}

	/**
	 * Sets the lang name.
	 *
	 * @param langName
	 *            the new lang name
	 */
	@JsonProperty("langName")
	public void setLangName(String langName) {
		this.langName = langName;
	}

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	@JsonProperty("params")
	public List<Object> getParams() {
		return params;
	}

	/**
	 * Sets the params.
	 *
	 * @param params
	 *            the new params
	 */
	@JsonProperty("params")
	public void setParams(List<Object> params) {
		this.params = params;
	}

	/**
	 * Gets the default debt char.
	 *
	 * @return the default debt char
	 */
	@JsonProperty("defaultDebtChar")
	public String getDefaultDebtChar() {
		return defaultDebtChar;
	}

	/**
	 * Sets the default debt char.
	 *
	 * @param defaultDebtChar
	 *            the new default debt char
	 */
	@JsonProperty("defaultDebtChar")
	public void setDefaultDebtChar(String defaultDebtChar) {
		this.defaultDebtChar = defaultDebtChar;
	}

	/**
	 * Gets the default debt sub char.
	 *
	 * @return the default debt sub char
	 */
	@JsonProperty("defaultDebtSubChar")
	public String getDefaultDebtSubChar() {
		return defaultDebtSubChar;
	}

	/**
	 * Sets the default debt sub char.
	 *
	 * @param defaultDebtSubChar
	 *            the new default debt sub char
	 */
	@JsonProperty("defaultDebtSubChar")
	public void setDefaultDebtSubChar(String defaultDebtSubChar) {
		this.defaultDebtSubChar = defaultDebtSubChar;
	}

	/**
	 * Gets the default debt rem fn type.
	 *
	 * @return the default debt rem fn type
	 */
	@JsonProperty("defaultDebtRemFnType")
	public String getDefaultDebtRemFnType() {
		return defaultDebtRemFnType;
	}

	/**
	 * Sets the default debt rem fn type.
	 *
	 * @param defaultDebtRemFnType
	 *            the new default debt rem fn type
	 */
	@JsonProperty("defaultDebtRemFnType")
	public void setDefaultDebtRemFnType(String defaultDebtRemFnType) {
		this.defaultDebtRemFnType = defaultDebtRemFnType;
	}

	/**
	 * Gets the default debt rem fn offset.
	 *
	 * @return the default debt rem fn offset
	 */
	@JsonProperty("defaultDebtRemFnOffset")
	public String getDefaultDebtRemFnOffset() {
		return defaultDebtRemFnOffset;
	}

	/**
	 * Sets the default debt rem fn offset.
	 *
	 * @param defaultDebtRemFnOffset
	 *            the new default debt rem fn offset
	 */
	@JsonProperty("defaultDebtRemFnOffset")
	public void setDefaultDebtRemFnOffset(String defaultDebtRemFnOffset) {
		this.defaultDebtRemFnOffset = defaultDebtRemFnOffset;
	}

	/**
	 * Gets the debt overloaded.
	 *
	 * @return the debt overloaded
	 */
	@JsonProperty("debtOverloaded")
	public Boolean getDebtOverloaded() {
		return debtOverloaded;
	}

	/**
	 * Sets the debt overloaded.
	 *
	 * @param debtOverloaded
	 *            the new debt overloaded
	 */
	@JsonProperty("debtOverloaded")
	public void setDebtOverloaded(Boolean debtOverloaded) {
		this.debtOverloaded = debtOverloaded;
	}

	/**
	 * Gets the debt rem fn type.
	 *
	 * @return the debt rem fn type
	 */
	@JsonProperty("debtRemFnType")
	public String getDebtRemFnType() {
		return debtRemFnType;
	}

	/**
	 * Sets the debt rem fn type.
	 *
	 * @param debtRemFnType
	 *            the new debt rem fn type
	 */
	@JsonProperty("debtRemFnType")
	public void setDebtRemFnType(String debtRemFnType) {
		this.debtRemFnType = debtRemFnType;
	}

	/**
	 * Gets the debt rem fn offset.
	 *
	 * @return the debt rem fn offset
	 */
	@JsonProperty("debtRemFnOffset")
	public String getDebtRemFnOffset() {
		return debtRemFnOffset;
	}

	/**
	 * Sets the debt rem fn offset.
	 *
	 * @param debtRemFnOffset
	 *            the new debt rem fn offset
	 */
	@JsonProperty("debtRemFnOffset")
	public void setDebtRemFnOffset(String debtRemFnOffset) {
		this.debtRemFnOffset = debtRemFnOffset;
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
