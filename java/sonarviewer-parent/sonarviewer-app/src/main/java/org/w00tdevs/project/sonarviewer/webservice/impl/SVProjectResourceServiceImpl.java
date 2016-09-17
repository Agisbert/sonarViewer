/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.webservice.impl
 *	Class: SVProjectResourceServiceImpl.java
 *	Author: Alberto
 *	Last update: 13-may-2016
 */
package org.w00tdevs.project.sonarviewer.webservice.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerProject;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerQProfile;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.service.ProfileService;
import org.w00tdevs.project.sonarviewer.service.ProjectService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService;

@Service
public class SVProjectResourceServiceImpl implements SVProjectResourceService {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private RuleService ruleService;

	@Autowired
	private IssueService issueService;

	@Autowired
	private ListTransformer listTransformer;

	@Autowired
	private Mapper dozerMapper;

	@Override
	public List<SonarViewerProject> getSonarViewerProjects() {
		List<SVProject> projects = projectService.getAvailableProjects();
		return listTransformer.transform(projects, SonarViewerProject.class);
	}

	@Override
	public SonarViewerProject getSonarViewerProject(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		return dozerMapper.map(project, SonarViewerProject.class);
	}

	@Override
	public List<SonarViewerQProfile> getSonarViewerProjectProfiles(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVProfile> profiles = profileService.getProfilesFromProject(project);
		return listTransformer.transform(profiles, SonarViewerQProfile.class);
	}

	@Override
	public List<SonarViewerRule> getSonarViewerProjectRules(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVRule> rules = ruleService.getRulesFromProject(project);
		return listTransformer.transform(rules, SonarViewerRule.class);
	}

	@Override
	public List<SonarViewerIssue> getSonarViewerProjectIssues(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVIssue> issues = issueService.getIssuesFromProject(project);
		return listTransformer.transform(issues, SonarViewerIssue.class);
	}

}
