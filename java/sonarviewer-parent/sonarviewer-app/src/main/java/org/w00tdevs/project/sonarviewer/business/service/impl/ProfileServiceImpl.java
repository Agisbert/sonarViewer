/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service.impl
*	Class: ProfileServiceImpl.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.business.database.dao.ProfileRepository;
import org.w00tdevs.project.sonarviewer.business.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.business.database.entity.Project;
import org.w00tdevs.project.sonarviewer.business.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.ProfilesSearchResponse;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.SonarQubeProfile;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.business.service.ProfileService;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;

/**
 * The Class RuleServiceImpl.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ProfileServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The rule respository. */
	@Autowired
	private ProfileRepository profileRepository;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * importRulesForProject(java.lang.String)
	 */
	@Override
	public List<Profile> importProfilesFromProject(Project project) {
		LOG.info("Importing PROFILES from project " + project);
		ProfilesSearchResponse psResponse = sonarQubeClient.getProfiles(project.getKey());
		List<SonarQubeProfile> sonarQubeProfiles = psResponse.getProfiles();
		List<Profile> profiles = listTransformer.transform(sonarQubeProfiles, Profile.class);
		LOG.info("Retrieved " + profiles.size() + " PROFILES from project " + project);
		List<Profile> savedProfiles = saveProfileIfNotExists(profiles, project);
		LOG.info("Saved " + savedProfiles.size() + " PROFILES from project " + project);
		return savedProfiles;
	}

	/**
	 * Save rules if not exists.
	 *
	 * @param profiles
	 *            the rules
	 * @return the list
	 */
	private List<Profile> saveProfileIfNotExists(List<Profile> profiles, Project project) {
		List<Profile> savedProfiles = new ArrayList<Profile>();
		for (Profile profile : profiles) {
			Rule savedProfile = profileRepository.findOneByKey(profile.getKey());
			if (savedProfile == null) {
				profile.setProjects(Collections.singletonList(project));
				savedProfiles.add(profileRepository.save(profile));
			}
		}
		return savedProfiles;
	}

}
