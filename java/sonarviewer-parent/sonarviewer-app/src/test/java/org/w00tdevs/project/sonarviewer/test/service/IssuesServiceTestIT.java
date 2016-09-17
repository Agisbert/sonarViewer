/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.test.service
*	Class: IssuesServiceTest.java
*	Author: Alberto
*	Last update: 01-abr-2016
*/
package org.w00tdevs.project.sonarviewer.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

public class IssuesServiceTestIT extends IntegrationTest {

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
	public void importIssuesRulesAndProfilesForProject() {

		List<SVProject> projects = projectService.importProjectsLike("tomcat");
		List<SVProfile> profiles = new ArrayList<SVProfile>();
		for (SVProject project : projects) {
			profiles.addAll(profileService.importProfilesFromProject(project));
		}

		List<SVRule> rules = new ArrayList<SVRule>();
		for (SVProfile profile : profiles) {
			rules.addAll(ruleService.importRulesFromProfile(profile));
		}

		SVProject project = projects.iterator().next();
		List<SVIssue> svIssues = issueService.importIssuesFromProject(project);
		Assert.assertNotNull(svIssues);
	}
}
