/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service.impl
*	Class: ProfileServiceImpl.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.IteratorUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.database.dao.ProfileRepository;
import org.w00tdevs.project.sonarviewer.database.dao.ProjectRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.ProfilesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeProfile;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.ProfileService;

/**
 * The Class ProfileServiceImpl.
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ProfileServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The profile repository. */
	@Autowired
	private ProfileRepository profileRepository;

	/** The project repository. */
	@Autowired
	private ProjectRepository projectRepository;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.RuleService#
	 * importRulesForProject(java.lang.String)
	 */
	@Override
	public List<SVProfile> importProfilesFromProject(SVProject svproject) {
		LOG.info("Importing PROFILES from project " + svproject);
		ProfilesSearchResponse psResponse = sonarQubeClient.getProfiles(svproject.getKey());
		List<SonarQubeProfile> sonarQubeProfiles = psResponse.getProfiles();
		List<Profile> profiles = listTransformer.transform(sonarQubeProfiles, Profile.class);
		LOG.info("Retrieved " + profiles.size() + " PROFILES from project " + svproject);
		List<Profile> savedProfiles = saveProfileIfNotExists(profiles, dozerMapper.map(svproject, Project.class));
		LOG.info("Saved " + savedProfiles.size() + " PROFILES from project " + svproject);
		List<SVProfile> saveSVProfiles = listTransformer.transform(savedProfiles, SVProfile.class);
		return saveSVProfiles;
	}

	/**
	 * Save profile if not exists.
	 *
	 * @param profiles
	 *            the profiles
	 * @param project
	 *            the project
	 * @return the list
	 */
	private List<Profile> saveProfileIfNotExists(List<Profile> profiles, Project project) {
		List<Profile> savedProfiles = new ArrayList<Profile>();
		for (Profile profile : profiles) {
			Profile savedProfile = profileRepository.findOneByKey(profile.getKey());
			if (savedProfile == null) {
				LOG.debug("Profile " + profile + " beeing saved");
				profile.setProjects(Collections.singletonList(project));
				savedProfiles.add(profileRepository.save(profile));
			} else {
				if (!savedProfile.getProjects().contains(project)) {
					LOG.debug("Profile " + profile + " beeing updated");
					savedProfile.getProjects().add(project);
					profileRepository.save(savedProfile);
				}
			}
		}
		return savedProfiles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.ProfileService#
	 * getProfilesFromProject(org.w00tdevs.project.sonarviewer.domain.SVProject)
	 */
	@Override
	public List<SVProfile> getProfilesFromProject(SVProject svProject) {
		Project project = projectRepository.findOne(svProject.getProjectId());
		List<Profile> profiles = project.getProfiles();
		return listTransformer.transform(profiles, SVProfile.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.service.ProfileService#getProfile(java.
	 * lang.Long)
	 */
	@Override
	public SVProfile getProfile(Long profileId) {
		Profile profile = profileRepository.findOne(profileId);
		return dozerMapper.map(profile, SVProfile.class);
	}

	/**
	 * Gets the available profiles.
	 *
	 * @return the available profiles
	 */
	@Override
	public List<SVProfile> getAvailableProfiles() {
		List<Profile> profiles = IteratorUtils.toList(profileRepository.findAll().iterator());
		return listTransformer.transform(profiles, SVProfile.class);
	}

}
