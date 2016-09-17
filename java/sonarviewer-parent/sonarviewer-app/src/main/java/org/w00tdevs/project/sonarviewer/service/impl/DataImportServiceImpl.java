/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service.impl
*	Class: DataImportServiceImpl.java
*	Author: Alberto
*	Last update: 29-may-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.config.ApplicationParams;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.service.RuleService;

/**
 * The Class DataImportServiceImpl.
 */
@Service
public class DataImportServiceImpl {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DataImportServiceImpl.class);

	/** The project service. */
	@Autowired
	private ProjectService projectService;

	/** The profile service. */
	@Autowired
	private ProfileService profileService;

	/** The rule service. */
	@Autowired
	private RuleService ruleService;

	/** The issue service. */
	@Autowired
	private IssueService issueService;

	/** The application params. */
	@Autowired
	private ApplicationParams applicationParams;

	/**
	 * Full import process.
	 */
	@Scheduled(initialDelay = 1800000, fixedRate = 1800000)
	public synchronized void fullImportProcess() {
		LOG.info("STARTING full import process");
		List<SVProject> existingProjects = projectService.getAvailableProjects();
		List<SVProfile> savedSVProfiles = new ArrayList<SVProfile>();
		// Rules
		List<SVRule> savedSVRules = new ArrayList<SVRule>();
		// Issues
		List<SVIssue> savedSVIssues = new ArrayList<SVIssue>();
		for (SVProject svProject : existingProjects) {
			LOG.info("Updating " + svProject);
			// Import/Update the profiles
			savedSVProfiles.addAll(profileService.importProfilesFromProject(svProject));
			// Import/Update the rules
			savedSVRules.addAll(ruleService.importRulesFromProject(svProject));
			// Import/Update the issues
			savedSVIssues.addAll(issueService.importIssuesFromProject(svProject));
			LOG.info("Updated " + svProject);
		}
		LOG.info(savedSVProfiles.size() + " new/updated Profiles");
		LOG.info(savedSVRules.size() + " new/updated Rules");
		LOG.info(savedSVIssues.size() + " new/updated Issues");
		LOG.info("END import process");

	}

	// To be launched every 30 minutes. Delta import for every project based on
	// last issue date
	/**
	 * Delta import process.
	 */
	@Scheduled(initialDelay = 1800000, fixedRate = 1800000)
	public synchronized void deltaImportProcess() {
		LOG.info("STARTING delta import process");
		List<SVProject> existingProjects = projectService.getAvailableProjects();
		for (SVProject svProject : existingProjects) {
			// There is no LastUpdateDate in sonar...
			Date lastDate = issueService.getLastCreationDateFromProject(svProject);
			List<SVIssue> savedSVIssues = issueService.importIssuesFromProjectSinceDate(svProject, lastDate);
			LOG.info(savedSVIssues.size() + " new/updated Issues");
		}
		LOG.info("END delta import process");
	}

	/**
	 * Initial import.
	 */
	@PostConstruct
	public void initialImport() {
		LOG.info("STARTING innitial import process");
		String projectName = applicationParams.INNITIAL_PROJECT;
		LOG.info("IMPORTING project -> " + projectName);
		// If the project currently does not exist
		try {
			if (!projectService.existsProject(projectName)) {
				projectService.importProjectsLike(projectName);
			}
			// Trigger full import process
			this.fullImportProcess();
			LOG.info("END innitial import process");
		} catch (Exception e) {
			LOG.error("Houston, problems retrieving FIRST PROJECT", e);
		}

	}

}
