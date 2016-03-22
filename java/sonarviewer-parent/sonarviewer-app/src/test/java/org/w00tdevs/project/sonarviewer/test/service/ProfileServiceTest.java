/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.test.service
*	Class: ProfileServiceTest.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.business.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.business.database.entity.Project;
import org.w00tdevs.project.sonarviewer.business.service.ProfileService;
import org.w00tdevs.project.sonarviewer.business.service.ProjectService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

/**
 * The Class ProfileServiceTest.
 */
public class ProfileServiceTest extends IntegrationTest {

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

		List<Project> projects = projectService.importProjects("tomcat");
		List<Profile> profiles = new ArrayList<Profile>();
		for (Project project : projects) {
			profiles.addAll(profileService.importProfilesFromProject(project));
		}

		Assert.assertNotNull(projects);
	}
}
