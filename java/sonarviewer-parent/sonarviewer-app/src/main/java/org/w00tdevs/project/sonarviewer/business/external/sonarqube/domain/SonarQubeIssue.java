/*
*	     ___    wWw ()_()(o)__(o)  .-.         _      wWw  wWw    wWw oo_    
*	    (___)__ (O)_(O o)(__  __)c(O_O)c      /||_    (O)_ (O)    (O)/  _)-< 
*	    (O)(O)  / __)|^_\  (  ) ,'.---.`,      /o_)   / __)( \    / )\__ `.  
*	    /  _\  / (   |(_))  )( / /|_|_|\ \    / |(\  / (    \ \  / /    `. | 
*	    | |_))(  _)  |  /  (  )| \_____/ |    | | ))(  _)   /  \/  \    _| | 
*	    | |_)) \ \_  )|\\   )/ '. `---' .`    | |//  \ \_   \ `--' / ,-'   | 
*	    (.'-'   \__)(/  \) (     `-...-'      \__/    \__)   `-..-' (_..--'  
*
*		sonarviewer-app - org.alberto.project.sonarviewer.sonarqube.domain - Issue.java
* 		09-mar-2016 - Alberto
*/

package org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain;

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

/**
 * The Class Issue.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "key", "rule", "severity", "component", "componentId", "project", "line", "textRange", "flows",
		"status", "message", "debt", "author", "tags", "creationDate", "updateDate" })
public class SonarQubeIssue {

	/** The key. */
	@JsonProperty("key")
	private String key;

	/** The rule. */
	@JsonProperty("rule")
	private String rule;

	/** The severity. */
	@JsonProperty("severity")
	private String severity;

	/** The component. */
	@JsonProperty("component")
	private String component;

	/** The component id. */
	@JsonProperty("componentId")
	private Integer componentId;

	/** The project. */
	@JsonProperty("project")
	private String project;

	/** The line. */
	@JsonProperty("line")
	private Integer line;

	/** The status. */
	@JsonProperty("status")
	private String status;

	/** The message. */
	@JsonProperty("message")
	private String message;

	/** The debt. */
	@JsonProperty("debt")
	private String debt;

	/** The author. */
	@JsonProperty("author")
	private String author;

	/** The tags. */
	@JsonProperty("tags")
	private List<String> tags = new ArrayList<String>();

	/** The creation date. */
	@JsonProperty("creationDate")
	private Date creationDate;

	/** The update date. */
	@JsonProperty("updateDate")
	private Date updateDate;

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
	 * @param key the new key
	 */
	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the rule.
	 *
	 * @return the rule
	 */
	@JsonProperty("rule")
	public String getRule() {
		return rule;
	}

	/**
	 * Sets the rule.
	 *
	 * @param rule the new rule
	 */
	@JsonProperty("rule")
	public void setRule(String rule) {
		this.rule = rule;
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
	 * @param severity the new severity
	 */
	@JsonProperty("severity")
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * Gets the component.
	 *
	 * @return the component
	 */
	@JsonProperty("component")
	public String getComponent() {
		return component;
	}

	/**
	 * Sets the component.
	 *
	 * @param component the new component
	 */
	@JsonProperty("component")
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * Gets the component id.
	 *
	 * @return the component id
	 */
	@JsonProperty("componentId")
	public Integer getComponentId() {
		return componentId;
	}

	/**
	 * Sets the component id.
	 *
	 * @param componentId the new component id
	 */
	@JsonProperty("componentId")
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	@JsonProperty("project")
	public String getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project the new project
	 */
	@JsonProperty("project")
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Gets the line.
	 *
	 * @return the line
	 */
	@JsonProperty("line")
	public Integer getLine() {
		return line;
	}

	/**
	 * Sets the line.
	 *
	 * @param line the new line
	 */
	@JsonProperty("line")
	public void setLine(Integer line) {
		this.line = line;
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
	 * @param status the new status
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the debt.
	 *
	 * @return the debt
	 */
	@JsonProperty("debt")
	public String getDebt() {
		return debt;
	}

	/**
	 * Sets the debt.
	 *
	 * @param debt the new debt
	 */
	@JsonProperty("debt")
	public void setDebt(String debt) {
		this.debt = debt;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
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
	 * @param tags the new tags
	 */
	@JsonProperty("tags")
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	@JsonProperty("creationDate")
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	@JsonProperty("creationDate")
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	@JsonProperty("updateDate")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate the new update date
	 */
	@JsonProperty("updateDate")
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	 * @param name the name
	 * @param value the value
	 */
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
