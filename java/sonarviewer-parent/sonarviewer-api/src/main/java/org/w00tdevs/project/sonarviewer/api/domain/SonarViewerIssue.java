/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerIssue.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/

package org.w00tdevs.project.sonarviewer.api.domain;

import java.util.Date;
import java.util.List;

/**
 * The Class SonarViewerIssue.
 */
public class SonarViewerIssue extends SonarViewerApiResource {

	/** The issue id. */
	private Long issueId;

	/** The key. */
	private String key;

	/** The rule. */
	private String rule;

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
	private List<String> tags;

	/** The creation date. */
	private Date creationDate;

	/** The update date. */
	private Date updateDate;

	/**
	 * Gets the issue id.
	 *
	 * @return the issue id
	 */
	public Long getIssueId() {
		return issueId;
	}

	/**
	 * Sets the issue id.
	 *
	 * @param issueId
	 *            the new issue id
	 */
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
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
	 * Gets the rule.
	 *
	 * @return the rule
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * Sets the rule.
	 *
	 * @param rule
	 *            the new rule
	 */
	public void setRule(String rule) {
		this.rule = rule;
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
	 * Gets the component.
	 *
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * Sets the component.
	 *
	 * @param component
	 *            the new component
	 */
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * Gets the component id.
	 *
	 * @return the component id
	 */
	public Integer getComponentId() {
		return componentId;
	}

	/**
	 * Sets the component id.
	 *
	 * @param componentId
	 *            the new component id
	 */
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project
	 *            the new project
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Gets the line.
	 *
	 * @return the line
	 */
	public Integer getLine() {
		return line;
	}

	/**
	 * Sets the line.
	 *
	 * @param line
	 *            the new line
	 */
	public void setLine(Integer line) {
		this.line = line;
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
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the debt.
	 *
	 * @return the debt
	 */
	public String getDebt() {
		return debt;
	}

	/**
	 * Sets the debt.
	 *
	 * @param debt
	 *            the new debt
	 */
	public void setDebt(String debt) {
		this.debt = debt;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate
	 *            the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate
	 *            the new update date
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
