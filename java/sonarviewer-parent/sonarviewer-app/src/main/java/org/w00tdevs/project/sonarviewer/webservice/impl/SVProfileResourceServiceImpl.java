/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVProfileResourceServiceImpl.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata.SonarViewerCountResourceType;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerQProfile;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService;

/**
 * The Class SVProfileResourceServiceImpl.
 */
public class SVProfileResourceServiceImpl implements SVProfileResourceService {

	/** The profile service. */
	@Autowired
	private ProfileService profileService;

	/** The rule service. */
	@Autowired
	private RuleService ruleService;

	/** The issue service. */
	@Autowired
	private IssueService issueService;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService#
	 * getSonarViewerProfileCount()
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProfileCount() {
		List<SVProfile> svProfiles = profileService.getAvailableProfiles();
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(SonarViewerCountResourceType.PROFILES_COUNT,
				String.valueOf(svProfiles.size()));
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService#
	 * getSonarViewerProfile(java.lang.Long)
	 */
	@Override
	public SonarViewerQProfile getSonarViewerProfile(Long profileId) {
		SVProfile svProfile = profileService.getProfile(profileId);
		return dozerMapper.map(svProfile, SonarViewerQProfile.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService#
	 * getSonarViewerProfileRules(java.lang.Long)
	 */
	@Override
	public List<SonarViewerRule> getSonarViewerProfileRules(Long profileId) {
		SVProfile svProfile = profileService.getProfile(profileId);
		List<SVRule> svRules = ruleService.getRulesFromProfile(svProfile);
		return listTransformer.transform(svRules, SonarViewerRule.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService#
	 * getSonarViewerProfileRulesCount(java.lang.Long)
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProfileRulesCount(Long profileId) {
		SVProfile svProfile = profileService.getProfile(profileId);
		List<SVRule> svRules = ruleService.getRulesFromProfile(svProfile);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountResourceType.RULES_COUNT, String.valueOf(svRules.size()));
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService#
	 * getSonarViewerProfileIssues(java.lang.Long)
	 */
	@Override
	public List<SonarViewerIssue> getSonarViewerProfileIssues(Long profileId) {
		SVProfile svProfile = profileService.getProfile(profileId);
		List<SVIssue> svIssues = issueService.getIssuesFromProfile(svProfile);
		return listTransformer.transform(svIssues, SonarViewerIssue.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProfileResourceService#
	 * getSonarViewerProfileIssuesCount(java.lang.Long)
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProfileIssuesCount(Long profileId) {
		SVProfile svProfile = profileService.getProfile(profileId);
		List<SVIssue> svIssues = issueService.getIssuesFromProfile(svProfile);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountResourceType.ISSUES_COUNT, String.valueOf(svIssues.size()));
		return metadata;
	}

}
