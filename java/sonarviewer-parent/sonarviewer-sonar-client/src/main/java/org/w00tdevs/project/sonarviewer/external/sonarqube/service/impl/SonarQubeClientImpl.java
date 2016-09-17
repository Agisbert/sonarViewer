/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-sonar-client
*	Package: org.w00tdevs.project.sonarviewer.external.sonarqube.service.impl
*	Class: SonarQubeClientImpl.java
*	Author: Alberto
*	Last update: 12-jun-2016
*/
package org.w00tdevs.project.sonarviewer.external.sonarqube.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.w00tdevs.project.sonarviewer.external.sonarqube.constants.SonarQubeConstants;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.IssuesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.ProfilesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.RulesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeProject;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;

/**
 * The Class SonarQubeClientImpl.
 */
/**
 * @author Alberto
 *
 */
public class SonarQubeClientImpl implements SonarQubeClient {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SonarQubeClientImpl.class);

	/** The sonar server url. */
	private String SONAR_SERVER_URL;

	/** The rest operations. */
	private RestOperations restOperations;

	/**
	 * Instantiates a new sonar qube client impl.
	 *
	 * @param SONAR_SERVER_URL
	 *            the sonar server url
	 */
	public SonarQubeClientImpl(String SONAR_SERVER_URL) {
		this.SONAR_SERVER_URL = SONAR_SERVER_URL;
		this.restOperations = new RestTemplate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.alberto.project.sonarviewer.sonarqube.client.SonarQubeClient#
	 * getIssues(java.lang.String)
	 */
	@Override
	public IssuesSearchResponse getIssues(String projectKey, Integer pageNumber) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SonarQubeConstants.IssuesSearch.PROJECTKEY, projectKey);
		map.put(SonarQubeConstants.IssuesSearch.PAGE, String.valueOf(pageNumber));
		return executeGet(SonarQubeConstants.IssuesSearch.PATH, IssuesSearchResponse.class, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.alberto.project.sonarviewer.sonarqube.client.SonarQubeClient#
	 * getIssues(java.lang.String, java.lang.String)
	 */
	@Override
	public IssuesSearchResponse getIssues(String projectKey, String author, Integer pageNumber) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SonarQubeConstants.IssuesSearch.PROJECTKEY, projectKey);
		map.put(SonarQubeConstants.IssuesSearch.AUTHOR, author);
		map.put(SonarQubeConstants.IssuesSearch.PAGE, String.valueOf(pageNumber));
		return executeGet(SonarQubeConstants.IssuesSearch.PATH, IssuesSearchResponse.class, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.external.sonarqube.service.
	 * SonarQubeClient#getIssues(java.lang.String, java.lang.Integer,
	 * java.util.Date)
	 */
	@Override
	public IssuesSearchResponse getIssues(String projectKey, Integer pageNumber, Date createdAfter) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SonarQubeConstants.IssuesSearch.PROJECTKEY, projectKey);
		SimpleDateFormat sdf = new SimpleDateFormat(SonarQubeConstants.DATE_FORMAT);
		map.put(SonarQubeConstants.IssuesSearch.CREATEDAFTER, sdf.format(createdAfter));
		map.put(SonarQubeConstants.IssuesSearch.PAGE, String.valueOf(pageNumber));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.alberto.project.sonarviewer.sonarqube.client.SonarQubeClient#
	 * getProfiles(java.lang.String, boolean)
	 */
	@Override
	public ProfilesSearchResponse getProfiles(String projectKey) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SonarQubeConstants.ProfilesSearch.PROJECTKEY, projectKey);
		map.put(SonarQubeConstants.ProfilesSearch.ACTIVE, Boolean.TRUE.toString());
		return executeGet(SonarQubeConstants.ProfilesSearch.PATH, ProfilesSearchResponse.class, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.alberto.project.sonarviewer.sonarqube.client.SonarQubeClient#getRules
	 * (java.lang.String)
	 */
	@Override
	public RulesSearchResponse getRules(String profileKey, boolean activeIssues, Integer pageNumber) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SonarQubeConstants.RulesSearch.QPROFILE, profileKey);
		map.put(SonarQubeConstants.RulesSearch.ACTIVE, Boolean.toString(activeIssues));
		map.put(SonarQubeConstants.RulesSearch.PAGE, String.valueOf(pageNumber));
		return executeGet(SonarQubeConstants.RulesSearch.PATH, RulesSearchResponse.class, map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.sonarqube.client.SonarQubeClient#
	 * getProjects(java.lang.String)
	 */
	@Override
	public List<SonarQubeProject> getProjects(String projectText) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SonarQubeConstants.ProjectSearch.TERM, projectText);
		map.put(SonarQubeConstants.ProjectSearch.FORMAT, SonarQubeConstants.ProjectSearch.FORMAT_DEFAULT_VALUE);
		// Response type of list
		ParameterizedTypeReference<List<SonarQubeProject>> responseType = new ParameterizedTypeReference<List<SonarQubeProject>>() {
		};
		// Exchange method support ParameterizedTypeReference
		try {
			ResponseEntity<List<SonarQubeProject>> responseEntity = restOperations.exchange(
					SONAR_SERVER_URL + SonarQubeConstants.ProjectSearch.PATH, HttpMethod.GET, null, responseType, map);
			return responseEntity.getBody();
		} catch (Exception e) {
			LOG.error("Exception invoking SONARQUBE server", e);
			throw e;
		}
	}

	/**
	 * Execute get.
	 *
	 * @param <T>
	 *            the generic type
	 * @param relativePath
	 *            the relative path
	 * @param returnType
	 *            the return type
	 * @param urlVariables
	 *            the url variables
	 * @return the t
	 */
	private <T> T executeGet(String relativePath, Class<T> returnType, Map<String, ?> urlVariables) {
		// RestTemplate is used only here.
		// Client methods are in charge of the businesses requests
		try {
			ResponseEntity<T> response = restOperations.getForEntity(SONAR_SERVER_URL + relativePath, returnType,
					urlVariables);
			return response.getBody();
		} catch (Exception e) {
			LOG.error("Exception invoking SONARQUBE server", e);
			throw e;
		}

	}

}
