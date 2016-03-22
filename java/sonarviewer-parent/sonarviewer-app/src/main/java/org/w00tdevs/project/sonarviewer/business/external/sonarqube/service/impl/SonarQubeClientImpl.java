/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.external.sonarqube.service.impl
*	Class: SonarQubeClientImpl.java
*	Author: Alberto
*	Last update: 17-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.external.sonarqube.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.constants.SonarQubeConstants;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.IssuesSearchResponse;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.ProfilesSearchResponse;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.RulesSearchResponse;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.SonarQubeProject;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.service.SonarQubeClient;

/**
 * The Class SonarQubeClientImpl.
 */
@Service
public class SonarQubeClientImpl implements SonarQubeClient {

	/** The sonar server url. */
	@Value("${sonar.server.url}")
	String sonarServerUrl;

	/** The rest operations. */
	@Autowired
	RestOperations restOperations;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.alberto.project.sonarviewer.sonarqube.client.SonarQubeClient#
	 * getIssues(java.lang.String)
	 */
	@Override
	public IssuesSearchResponse getIssues(String projectKey, Integer pageNumber) {
		Map<String, String> map = Collections.singletonMap(SonarQubeConstants.IssuesSearch.PROJECTKEY, projectKey);
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
		ResponseEntity<List<SonarQubeProject>> responseEntity = restOperations.exchange(
				sonarServerUrl + SonarQubeConstants.ProjectSearch.PATH, HttpMethod.GET, null, responseType, map);
		return responseEntity.getBody();
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
		ResponseEntity<T> response = restOperations.getForEntity(sonarServerUrl + relativePath, returnType,
				urlVariables);
		return response.getBody();
	}

}
