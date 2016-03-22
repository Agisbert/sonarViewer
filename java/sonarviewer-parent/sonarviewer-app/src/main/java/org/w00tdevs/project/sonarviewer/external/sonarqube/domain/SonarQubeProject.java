/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.sonarqube.client.domain
 *	Class: SonarQubeProject.java
 *	Author: Alberto
 *	Last update: 15-mar-2016
 */

package org.w00tdevs.project.sonarviewer.external.sonarqube.domain;

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
 * The Class SonarQubeProject.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "k", "nm", "sc", "qu" })
public class SonarQubeProject {

	/** The id. */
	@JsonProperty("id")
	private String id;

	/** The k. */
	@JsonProperty("k")
	private String k;

	/** The nm. */
	@JsonProperty("nm")
	private String nm;

	/** The sc. */
	@JsonProperty("sc")
	private String sc;

	/** The qu. */
	@JsonProperty("qu")
	private String qu;

	/** The additional properties. */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the k.
	 *
	 * @return the k
	 */
	@JsonProperty("k")
	public String getK() {
		return k;
	}

	/**
	 * Sets the k.
	 *
	 * @param k
	 *            the new k
	 */
	@JsonProperty("k")
	public void setK(String k) {
		this.k = k;
	}

	/**
	 * Gets the nm.
	 *
	 * @return the nm
	 */
	@JsonProperty("nm")
	public String getNm() {
		return nm;
	}

	/**
	 * Sets the nm.
	 *
	 * @param nm
	 *            the new nm
	 */
	@JsonProperty("nm")
	public void setNm(String nm) {
		this.nm = nm;
	}

	/**
	 * Gets the sc.
	 *
	 * @return the sc
	 */
	@JsonProperty("sc")
	public String getSc() {
		return sc;
	}

	/**
	 * Sets the sc.
	 *
	 * @param sc
	 *            the new sc
	 */
	@JsonProperty("sc")
	public void setSc(String sc) {
		this.sc = sc;
	}

	/**
	 * Gets the qu.
	 *
	 * @return the qu
	 */
	@JsonProperty("qu")
	public String getQu() {
		return qu;
	}

	/**
	 * Sets the qu.
	 *
	 * @param qu
	 *            the new qu
	 */
	@JsonProperty("qu")
	public void setQu(String qu) {
		this.qu = qu;
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
