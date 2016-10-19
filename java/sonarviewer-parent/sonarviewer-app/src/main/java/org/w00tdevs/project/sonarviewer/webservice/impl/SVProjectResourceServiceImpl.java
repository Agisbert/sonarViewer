/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVProjectResourceServiceImpl.java
*	Author: Alberto
*	Last update: 14-oct-2016
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
		List<SVProject> svProjects = projectService.getAvailableProjects();
		return listTransformer.transform(svProjects, SonarViewerProject.class);
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
		SVProject svProject = projectService.getProject(projectId);
		return dozerMapper.map(svProject, SonarViewerProject.class);
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
		SVProject svProject = projectService.getProject(projectId);
		List<SVProfile> svProfiles = profileService.getProfilesFromProject(svProject);
		return listTransformer.transform(svProfiles, SonarViewerQProfile.class);
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
		SVProject svProject = projectService.getProject(projectId);
		List<SVRule> svRules = ruleService.getRulesFromProject(svProject);
		return listTransformer.transform(svRules, SonarViewerRule.class);
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
		SVProject svProject = projectService.getProject(projectId);
		List<SVIssue> issues = issueService.getIssuesFromProject(svProject);
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
		for (SonarViewerProject svProject : getSonarViewerProjects()) {
			SonarViewerMetadata metadata = new SonarViewerMetadata(svProject);
			SonarViewerCountMetadata profilesMetadata = getSonarViewerProjectProfilesCount(svProject.getProjectId());
			SonarViewerCountMetadata rulesMetadata = getSonarViewerProjectRulesCount(svProject.getProjectId());
			SonarViewerCountMetadata issuesMetadata = getSonarViewerProjectIssuesCount(svProject.getProjectId());
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
		List<SVProject> svProjects = projectService.getAvailableProjects();
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountResourceType.PROJECTS_COUNT,
				String.valueOf(svProjects.size()));
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
		SVProject svProjects = projectService.getProject(projectId);
		List<SVProfile> svProfiles = profileService.getProfilesFromProject(svProjects);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountResourceType.PROFILES_COUNT,
				String.valueOf(svProfiles.size()));
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
		SVProject svProject = projectService.getProject(projectId);
		List<SVRule> svRules = ruleService.getRulesFromProject(svProject);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountResourceType.RULES_COUNT, String.valueOf(svRules.size()));
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
		SVProject svProject = projectService.getProject(projectId);
		List<SVIssue> svIssues = issueService.getIssuesFromProject(svProject);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(
				SonarViewerCountMetadata.SonarViewerCountResourceType.ISSUES_COUNT, String.valueOf(svIssues.size()));
		return metadata;
	}

}
