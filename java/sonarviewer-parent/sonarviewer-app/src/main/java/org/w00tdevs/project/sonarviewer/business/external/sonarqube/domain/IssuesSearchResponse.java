/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain
 *	Class: IssuesSearchResponse.java
 *	Author: Alberto
 *	Last update: 16-mar-2016
 */

package org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain;

import java.util.ArrayList;
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
 * The Class IssuesSearchResponse.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "total", "p", "ps", "paging", "issues", "components" })
public class IssuesSearchResponse {

	/** The total. */
	@JsonProperty("total")
	private Integer total;

	/** The p. */
	@JsonProperty("p")
	private Integer p;

	/** The ps. */
	@JsonProperty("ps")
	private Integer ps;

	/** The issues. */
	@JsonProperty("issues")
	private List<SonarQubeIssue> issues = new ArrayList<SonarQubeIssue>();

	/** The additional properties. */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	@JsonProperty("total")
	public Integer getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total
	 *            the new total
	 */
	@JsonProperty("total")
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * Gets the p.
	 *
	 * @return the p
	 */
	@JsonProperty("p")
	public Integer getP() {
		return p;
	}

	/**
	 * Sets the p.
	 *
	 * @param p
	 *            the new p
	 */
	@JsonProperty("p")
	public void setP(Integer p) {
		this.p = p;
	}

	/**
	 * Gets the ps.
	 *
	 * @return the ps
	 */
	@JsonProperty("ps")
	public Integer getPs() {
		return ps;
	}

	/**
	 * Sets the ps.
	 *
	 * @param ps
	 *            the new ps
	 */
	@JsonProperty("ps")
	public void setPs(Integer ps) {
		this.ps = ps;
	}

	/**
	 * Gets the issues.
	 *
	 * @return the issues
	 */
	@JsonProperty("issues")
	public List<SonarQubeIssue> getIssues() {
		return issues;
	}

	/**
	 * Sets the issues.
	 *
	 * @param issues
	 *            the new issues
	 */
	@JsonProperty("issues")
	public void setIssues(List<SonarQubeIssue> issues) {
		this.issues = issues;
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

	/**
	 * Gets the number of pages.
	 *
	 * @return the number of pages
	 */
	public int getNumberOfPages() {
		return (this.getTotal() % this.getPs() > 0) ? this.getTotal() / this.getPs() + 1
				: this.getTotal() / this.getPs();

	}

}
