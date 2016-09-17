/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.test.service
*	Class: ProfileServiceTest.java
*	Author: Alberto
*	Last update: 01-abr-2016
*/
package org.w00tdevs.project.sonarviewer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

/**
 * The Class ProfileServiceTest.
 */
public class ProfileServiceTestIT extends IntegrationTest {

	/** The profile service. */
	@Autowired
	private ProfileService profileService;

	/** The project service. */
	@Autowired
	private ProjectService projectService;

	/**
	 * Context loaded.
	 */
	@Test
	public void contextLoaded() {
		Assert.assertNotNull(projectService);
		Assert.assertNotNull(profileService);
	}

	/**
	 * Import project.
	 */
	@Test
	public void importProfilesProject() {

		List<SVProject> projects = projectService.importProjectsLike("tomcat");
		List<SVProfile> profiles = new ArrayList<SVProfile>();
		for (SVProject project : projects) {
			profiles.addAll(profileService.importProfilesFromProject(project));
		}

		Assert.assertNotNull(projects);
	}
}
