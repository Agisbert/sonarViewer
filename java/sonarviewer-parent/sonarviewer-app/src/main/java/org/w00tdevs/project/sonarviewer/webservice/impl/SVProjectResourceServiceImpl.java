/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVProjectResourceServiceImpl.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerMetadata;
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

/**
 * The Class SVProjectResourceServiceImpl.
 */
@Service
public class SVProjectResourceServiceImpl implements SVProjectResourceService {

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

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjects()
	 */
	@Override
	public List<SonarViewerProject> getSonarViewerProjects() {
		List<SVProject> projects = projectService.getAvailableProjects();
		return listTransformer.transform(projects, SonarViewerProject.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProject(java.lang.Long)
	 */
	@Override
	public SonarViewerProject getSonarViewerProject(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		return dozerMapper.map(project, SonarViewerProject.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectProfiles(java.lang.Long)
	 */
	@Override
	public List<SonarViewerQProfile> getSonarViewerProjectProfiles(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVProfile> profiles = profileService.getProfilesFromProject(project);
		return listTransformer.transform(profiles, SonarViewerQProfile.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectRules(java.lang.Long)
	 */
	@Override
	public List<SonarViewerRule> getSonarViewerProjectRules(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVRule> rules = ruleService.getRulesFromProject(project);
		return listTransformer.transform(rules, SonarViewerRule.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectIssues(java.lang.Long)
	 */
	@Override
	public List<SonarViewerIssue> getSonarViewerProjectIssues(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVIssue> issues = issueService.getIssuesFromProject(project);
		return listTransformer.transform(issues, SonarViewerIssue.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectsSumary()
	 */
	@Override
	public List<SonarViewerMetadata> getSonarViewerProjectsSumary() {
		List<SonarViewerMetadata> metadataList = new ArrayList<SonarViewerMetadata>();
		for (SonarViewerProject project : getSonarViewerProjects()) {
			SonarViewerMetadata metadata = new SonarViewerMetadata(project);
			SonarViewerCountMetadata profilesMetadata = getSonarViewerProjectProfilesCount(project.getProjectId());
			SonarViewerCountMetadata rulesMetadata = getSonarViewerProjectRulesCount(project.getProjectId());
			SonarViewerCountMetadata issuesMetadata = getSonarViewerProjectIssuesCount(project.getProjectId());
			metadata.setMetadataList(Arrays.asList(profilesMetadata, rulesMetadata, issuesMetadata));
			metadataList.add(metadata);
		}
		return metadataList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectsCount()
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProjectsCount() {
		List<SVProject> projects = projectService.getAvailableProjects();
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountMetadataType.PROJECTS_COUNT, String.valueOf(projects.size()));
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectProfilesCount(java.lang.Long)
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProjectProfilesCount(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVProfile> profiles = profileService.getProfilesFromProject(project);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountMetadataType.PROFILES_COUNT, String.valueOf(profiles.size()));
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectRulesCount(java.lang.Long)
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProjectRulesCount(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVRule> rules = ruleService.getRulesFromProject(project);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountMetadataType.RULES_COUNT, String.valueOf(rules.size()));
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.webservice.SVProjectResourceService#
	 * getSonarViewerProjectIssuesCount(java.lang.Long)
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerProjectIssuesCount(Long projectId) {
		SVProject project = projectService.getProject(projectId);
		List<SVIssue> issues = issueService.getIssuesFromProject(project);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountMetadataType.ISSUES_COUNT, String.valueOf(issues.size()));
		return metadata;
	}

}
