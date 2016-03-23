/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.entity
*	Class: Issue.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/

package org.w00tdevs.project.sonarviewer.database.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.ToString;

/**
 * The Class Issue.
 */
@Entity
@Table(name = "issue")
@ToString(includeFieldNames = true, of = { "issueId", "key", "severity" })
public class Issue {

	/** The issue id. */
	@GenericGenerator(name = "issueNumericGenerator", strategy = "increment")
	@GeneratedValue(generator = "issueNumericGenerator")
	@Id
	@Column
	private Long issueId;

	/** The key. */
	@Column
	private String key;

	/** The severity. */
	@Column
	private String severity;

	/** The component. */
	@Column
	private String component;

	/** The component id. */
	@Column
	private Integer componentId;

	/** The line. */
	@Column
	private Integer line;

	/** The status. */
	@Column
	private String status;

	/** The message. */
	@Column
	private String message;

	/** The debt. */
	@Column
	private String debt;

	/** The author. */
	@Column
	private String author;

	/** The creation date. */
	@Column
	private Date creationDate;

	/** The update date. */
	@Column
	private Date updateDate;

	/** The rule. */
	@ManyToOne
	@JoinColumn(name = "ruleId")
	private Rule rule;

	/** The project. */
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;

	/** The tags. */
	@ManyToMany
	@JoinTable(name = "issuestags", joinColumns = { @JoinColumn(name = "issueId") }, inverseJoinColumns = {
			@JoinColumn(name = "name") })
	private List<Tag> tags;

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

	/**
	 * Gets the rule.
	 *
	 * @return the rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * Sets the rule.
	 *
	 * @param rule
	 *            the new rule
	 */
	public void setRule(Rule rule) {
		this.rule = rule;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project
	 *            the new project
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags
	 *            the new tags
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
