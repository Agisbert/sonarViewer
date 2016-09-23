/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service.impl
*	Class: ProjectServiceImpl.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.IteratorUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.database.dao.ProjectRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeProject;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.ProjectService;

/**
 * The Class ProjectServiceImpl.
 */
/**
 * @author Alberto
 *
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

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
	public List<SVProject> importProjectsLike(String projectText) {
		// Retrieve the list of projects
		LOG.info("Importing PROJECTS matching " + projectText);
		List<SonarQubeProject> sonarQubeProjects = sonarQubeClient.getProjects(projectText);
		LOG.info("Retrieved " + sonarQubeProjects.size() + " PROJECTS matching " + projectText);
		// Convert it to db entities
		List<Project> projects = listTransformer.transform(sonarQubeProjects, Project.class);
		// Persist and get the saved ones;
		List<Project> savedProjects = IteratorUtils.toList(projectRepository.save(projects).iterator());
		LOG.info("Saved " + savedProjects.size() + " PROJECTS matching " + projectText);
		// Convert it to domain classes
		List<SVProject> savedSVProjects = listTransformer.transform(savedProjects, SVProject.class);
		return savedSVProjects;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.ProjectService#
	 * getAvailableProjects()
	 */
	@Override
	public List<SVProject> getAvailableProjects() {
		// Retrieve them all
		List<Project> projects = IteratorUtils.toList(projectRepository.findAll().iterator());
		// Convert it to domain classes
		List<SVProject> svProjects = listTransformer.transform(projects, SVProject.class);
		return svProjects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.ProjectService#
	 * getAvailableProjectsInSonarLike(java.lang.String)
	 */
	@Override
	public List<SVProject> getAvailableProjectsInSonarLike(String projectText) {
		LOG.info("Checking PROJECTS matching " + projectText);
		List<SonarQubeProject> sonarQubeProjects = sonarQubeClient.getProjects(projectText);
		LOG.info("Retrieved " + sonarQubeProjects.size() + " PROJECTS matching " + projectText);
		// Convert it to domain classes
		List<SVProject> svProjects = listTransformer.transform(sonarQubeProjects, SVProject.class);
		return svProjects;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.service.ProjectService#existsProject(
	 * java.lang.String)
	 */
	@Override
	public boolean existsProject(String project) {
		List<Project> projects = projectRepository.findByName(project);
		return projects.isEmpty() ? false : true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.service.ProjectService#getProject(java.
	 * lang.String)
	 */
	@Override
	public SVProject getProject(Long projectId) {
		return dozerMapper.map(projectRepository.findOne(projectId), SVProject.class);
	}

}
