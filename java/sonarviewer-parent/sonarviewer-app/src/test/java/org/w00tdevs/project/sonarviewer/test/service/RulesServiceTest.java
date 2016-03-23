/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.test.service
*	Class: RulesServiceTest.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

/**
 * The Class RulesServiceTest.
 */
public class RulesServiceTest extends IntegrationTest {

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
	public void importProject() {
		List<Project> projects = projectService.importProjects("tomcat");
		List<Profile> profiles = new ArrayList<Profile>();
		for (Project project : projects) {
			profiles.addAll(profileService.importProfilesFromProject(project));
		}
		List<Rule> rules = new ArrayList<Rule>();
		for (Profile profile : profiles) {
			rules.addAll(ruleService.importRulesFromProfile(profile));
		}

		Assert.assertNotNull(projects);
		Assert.assertNotNull(profiles);
		Assert.assertNotNull(rules);
		Assert.assertFalse(projects.isEmpty());
		Assert.assertFalse(profiles.isEmpty());
		Assert.assertFalse(rules.isEmpty());

		Project project = projects.iterator().next();
		List<SonarViewerRule> dbRules = ruleService.getSonarViewerRuleList(project.getProjectId());
	}
}
