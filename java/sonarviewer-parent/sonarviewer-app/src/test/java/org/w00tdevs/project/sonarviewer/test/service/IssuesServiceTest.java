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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.business.service.IssueService;
import org.w00tdevs.project.sonarviewer.business.service.ProjectService;
import org.w00tdevs.project.sonarviewer.business.service.RuleService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

public class IssuesServiceTest extends IntegrationTest {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private RuleService ruleService;

	@Autowired
	private IssueService issueService;

	@Test
	public void contextLoaded() {
		Assert.assertNotNull(projectService);
	}

	@Test
	public void importProject() {

	}
}
