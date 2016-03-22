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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

	}
}
