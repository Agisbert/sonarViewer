/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerRule.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/

package org.w00tdevs.project.sonarviewer.api.domain;

import java.util.Date;
import java.util.List;

/**
 * The Class SonarViewerRule.
 */
public class SonarViewerRule extends SonarViewerApiResource {

	/** The rule id. */
	private Long ruleId;

	/** The key. */
	private String key;

	/** The repo. */
	private String repo;

	/** The name. */
	private String name;

	/** The created at. */
	private Date createdAt;

	/** The html desc. */
	private String htmlDesc;

	/** The severity. */
	private String severity;

	/** The status. */
	private String status;

	/** The internal key. */
	private String internalKey;

	/** The is template. */
	private Boolean isTemplate;

	/** The tags. */
	private List<String> tags;

	/** The lang. */
	private String lang;

	/** The lang name. */
	private String langName;

	/** The default debt char. */
	private String defaultDebtChar;

	/** The default debt sub char. */
	private String defaultDebtSubChar;

	/** The default debt rem fn type. */
	private String defaultDebtRemFnType;

	/** The default debt rem fn offset. */
	private String defaultDebtRemFnOffset;

	/** The debt overloaded. */
	private Boolean debtOverloaded;

	/** The debt rem fn type. */
	private String debtRemFnType;

	/** The debt rem fn offset. */
	private String debtRemFnOffset;

	/** The profile key. */
	private String profileKey;

	/**
	 * Gets the rule id.
	 *
	 * @return the rule id
	 */
	public Long getRuleId() {
		return ruleId;
	}

	/**
	 * Sets the rule id.
	 *
	 * @param ruleId
	 *            the new rule id
	 */
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
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
	 * Gets the repo.
	 *
	 * @return the repo
	 */
	public String getRepo() {
		return repo;
	}

	/**
	 * Sets the repo.
	 *
	 * @param repo
	 *            the new repo
	 */
	public void setRepo(String repo) {
		this.repo = repo;
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
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt
	 *            the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the html desc.
	 *
	 * @return the html desc
	 */
	public String getHtmlDesc() {
		return htmlDesc;
	}

	/**
	 * Sets the html desc.
	 *
	 * @param htmlDesc
	 *            the new html desc
	 */
	public void setHtmlDesc(String htmlDesc) {
		this.htmlDesc = htmlDesc;
	}

	/**
	 * Gets the severity.
	 *
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * Sets the severity.
	 *
	 * @param severity
	 *            the new severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the internal key.
	 *
	 * @return the internal key
	 */
	public String getInternalKey() {
		return internalKey;
	}

	/**
	 * Sets the internal key.
	 *
	 * @param internalKey
	 *            the new internal key
	 */
	public void setInternalKey(String internalKey) {
		this.internalKey = internalKey;
	}

	/**
	 * Gets the is template.
	 *
	 * @return the is template
	 */
	public Boolean getIsTemplate() {
		return isTemplate;
	}

	/**
	 * Sets the is template.
	 *
	 * @param isTemplate
	 *            the new is template
	 */
	public void setIsTemplate(Boolean isTemplate) {
		this.isTemplate = isTemplate;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags
	 *            the new tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Gets the lang.
	 *
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Sets the lang.
	 *
	 * @param lang
	 *            the new lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * Gets the lang name.
	 *
	 * @return the lang name
	 */
	public String getLangName() {
		return langName;
	}

	/**
	 * Sets the lang name.
	 *
	 * @param langName
	 *            the new lang name
	 */
	public void setLangName(String langName) {
		this.langName = langName;
	}

	/**
	 * Gets the default debt char.
	 *
	 * @return the default debt char
	 */
	public String getDefaultDebtChar() {
		return defaultDebtChar;
	}

	/**
	 * Sets the default debt char.
	 *
	 * @param defaultDebtChar
	 *            the new default debt char
	 */
	public void setDefaultDebtChar(String defaultDebtChar) {
		this.defaultDebtChar = defaultDebtChar;
	}

	/**
	 * Gets the default debt sub char.
	 *
	 * @return the default debt sub char
	 */
	public String getDefaultDebtSubChar() {
		return defaultDebtSubChar;
	}

	/**
	 * Sets the default debt sub char.
	 *
	 * @param defaultDebtSubChar
	 *            the new default debt sub char
	 */
	public void setDefaultDebtSubChar(String defaultDebtSubChar) {
		this.defaultDebtSubChar = defaultDebtSubChar;
	}

	/**
	 * Gets the default debt rem fn type.
	 *
	 * @return the default debt rem fn type
	 */
	public String getDefaultDebtRemFnType() {
		return defaultDebtRemFnType;
	}

	/**
	 * Sets the default debt rem fn type.
	 *
	 * @param defaultDebtRemFnType
	 *            the new default debt rem fn type
	 */
	public void setDefaultDebtRemFnType(String defaultDebtRemFnType) {
		this.defaultDebtRemFnType = defaultDebtRemFnType;
	}

	/**
	 * Gets the default debt rem fn offset.
	 *
	 * @return the default debt rem fn offset
	 */
	public String getDefaultDebtRemFnOffset() {
		return defaultDebtRemFnOffset;
	}

	/**
	 * Sets the default debt rem fn offset.
	 *
	 * @param defaultDebtRemFnOffset
	 *            the new default debt rem fn offset
	 */
	public void setDefaultDebtRemFnOffset(String defaultDebtRemFnOffset) {
		this.defaultDebtRemFnOffset = defaultDebtRemFnOffset;
	}

	/**
	 * Gets the debt overloaded.
	 *
	 * @return the debt overloaded
	 */
	public Boolean getDebtOverloaded() {
		return debtOverloaded;
	}

	/**
	 * Sets the debt overloaded.
	 *
	 * @param debtOverloaded
	 *            the new debt overloaded
	 */
	public void setDebtOverloaded(Boolean debtOverloaded) {
		this.debtOverloaded = debtOverloaded;
	}

	/**
	 * Gets the debt rem fn type.
	 *
	 * @return the debt rem fn type
	 */
	public String getDebtRemFnType() {
		return debtRemFnType;
	}

	/**
	 * Sets the debt rem fn type.
	 *
	 * @param debtRemFnType
	 *            the new debt rem fn type
	 */
	public void setDebtRemFnType(String debtRemFnType) {
		this.debtRemFnType = debtRemFnType;
	}

	/**
	 * Gets the debt rem fn offset.
	 *
	 * @return the debt rem fn offset
	 */
	public String getDebtRemFnOffset() {
		return debtRemFnOffset;
	}

	/**
	 * Sets the debt rem fn offset.
	 *
	 * @param debtRemFnOffset
	 *            the new debt rem fn offset
	 */
	public void setDebtRemFnOffset(String debtRemFnOffset) {
		this.debtRemFnOffset = debtRemFnOffset;
	}

	/**
	 * Gets the profile key.
	 *
	 * @return the profile key
	 */
	public String getProfileKey() {
		return profileKey;
	}

	/**
	 * Sets the profile key.
	 *
	 * @param profileKey
	 *            the new profile key
	 */
	public void setProfileKey(String profileKey) {
		this.profileKey = profileKey;
	}

}
