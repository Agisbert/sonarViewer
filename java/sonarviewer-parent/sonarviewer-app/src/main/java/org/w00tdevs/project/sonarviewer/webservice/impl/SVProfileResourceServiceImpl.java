/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVProfileResourceServiceImpl.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerQProfile;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
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

}
