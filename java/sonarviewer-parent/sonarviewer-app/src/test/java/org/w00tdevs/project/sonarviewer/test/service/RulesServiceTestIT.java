/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.test.service
*	Class: RulesServiceTest.java
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
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

/**
 * The Class RulesServiceTest.
 */
public class RulesServiceTestIT extends IntegrationTest {

	/** The rule service. */
	@Autowired
	private RuleService ruleService;

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
		Assert.assertNotNull(ruleService);
	}

	/**
	 * Import project.
	 */
	@Test
	public void importRulesFromProject() {
		List<SVProject> projects = projectService.importProjectsLike("tomcat");
		List<SVProfile> profiles = new ArrayList<SVProfile>();
		for (SVProject project : projects) {
			profiles.addAll(profileService.importProfilesFromProject(project));
		}
		List<SVRule> rules = new ArrayList<SVRule>();
		for (SVProfile profile : profiles) {
			rules.addAll(ruleService.importRulesFromProfile(profile));
		}

		Assert.assertNotNull(projects);
		Assert.assertNotNull(profiles);
		Assert.assertNotNull(rules);
		Assert.assertFalse(projects.isEmpty());
		Assert.assertFalse(profiles.isEmpty());
		Assert.assertFalse(rules.isEmpty());

		SVProject project = projects.iterator().next();
		List<SVRule> svRules = ruleService.getRulesFromProject(project);

		Assert.assertNotNull(svRules);
		Assert.assertFalse(svRules.isEmpty());
	}
}
