/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.test.service
*	Class: ProjectServiceTest.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.business.database.entity.Project;
import org.w00tdevs.project.sonarviewer.business.service.ProjectService;
import org.w00tdevs.project.sonarviewer.test.generic.IntegrationTest;

public class ProjectServiceTest extends IntegrationTest {

	@Autowired
	private ProjectService projectService;

	@Test
	public void contextLoaded() {
		Assert.assertNotNull(projectService);
	}

	@Test
	public void importProject() {
		List<Project> projects = projectService.importProjects("tomcat");
		Assert.assertNotNull(projects);
	}
}
