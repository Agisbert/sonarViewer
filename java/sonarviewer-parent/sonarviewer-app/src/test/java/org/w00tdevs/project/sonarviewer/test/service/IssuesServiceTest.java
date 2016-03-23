/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.test.service
 *	Class: IssuesServiceTest.java
 *	Author: Alberto
 *	Last update: 22-mar-2016
 */
package org.w00tdevs.project.sonarviewer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.database.entity.Issue;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

public class IssuesServiceTest extends IntegrationTest {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private RuleService ruleService;

	@Autowired
	private IssueService issueService;

	@Autowired
	private ProfileService profileService;

	@Test
	public void contextLoaded() {
		Assert.assertNotNull(projectService);
	}

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

		Project project = projects.iterator().next();
		List<Issue> issues = issueService.importIssuesFromProject(project);
		Assert.assertNotNull(issues);
	}
}
