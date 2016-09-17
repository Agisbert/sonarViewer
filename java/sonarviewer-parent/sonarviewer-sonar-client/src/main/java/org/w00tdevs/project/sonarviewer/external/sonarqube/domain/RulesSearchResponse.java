/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.sonarqube.domain
*	Class: RulesSearchResponse.java
*	Author: Alberto
*	Last update: 10-mar-2016
*/

package org.w00tdevs.project.sonarviewer.external.sonarqube.domain;

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
 * The Class RulesSearchResponse.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "total", "p", "ps", "rules" })
public class RulesSearchResponse {

	/** The total. */
	@JsonProperty("total")
	private Integer total;

	/** The p. */
	@JsonProperty("p")
	private Integer p;

	/** The ps. */
	@JsonProperty("ps")
	private Integer ps;

	/** The rules. */
	@JsonProperty("rules")
	private List<SonarQubeRule> rules = new ArrayList<SonarQubeRule>();

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
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	@JsonProperty("rules")
	public List<SonarQubeRule> getRules() {
		return rules;
	}

	/**
	 * Sets the rules.
	 *
	 * @param rules
	 *            the new rules
	 */
	@JsonProperty("rules")
	public void setRules(List<SonarQubeRule> rules) {
		this.rules = rules;
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

	public Integer getNumberOfPages() {
		return (this.getTotal() % this.getPs() > 0) ? this.getTotal() / this.getPs() + 1
				: this.getTotal() / this.getPs();
	}

}
