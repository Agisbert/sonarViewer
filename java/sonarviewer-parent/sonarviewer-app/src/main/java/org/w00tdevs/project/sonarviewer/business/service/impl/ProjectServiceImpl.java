/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service.impl
*	Class: ProjectServiceImpl.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.service.impl;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.business.database.dao.ProjectRepository;
import org.w00tdevs.project.sonarviewer.business.database.entity.Project;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain.SonarQubeProject;
import org.w00tdevs.project.sonarviewer.business.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.business.service.ProjectService;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;

/**
 * The Class ProjectServiceImpl.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/** The project repository. */
	@Autowired
	private ProjectRepository projectRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.business.service.ProjectService#
	 * importProjects(java.lang.String)
	 */
	@Override
	public List<Project> importProjects(String projectText) {
		// Retrieve the list of projects
		LOG.info("Importing PROJECTS matching " + projectText);
		List<SonarQubeProject> sonarQubeProjects = sonarQubeClient.getProjects(projectText);
		LOG.info("Retrieved " + sonarQubeProjects.size() + " PROJECTS matching " + projectText);
		// Convert it to db entities
		List<Project> projects = listTransformer.transform(sonarQubeProjects, Project.class);
		// Persist and get the saved ones;
		List<Project> savedProjects = IteratorUtils.toList(projectRepository.save(projects).iterator());
		LOG.info("Saved " + savedProjects.size() + " PROJECTS matching " + projectText);
		return savedProjects;

	}

	@Override
	public List<Project> getAvailableProjects() {
		return (List<Project>) projectRepository.findAll();
	}

}
