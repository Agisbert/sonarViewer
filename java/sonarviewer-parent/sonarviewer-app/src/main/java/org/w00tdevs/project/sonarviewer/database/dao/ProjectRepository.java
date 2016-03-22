/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.database.dao
 *	Class: ProjectRepository.java
 *	Author: Alberto
 *	Last update: 16-mar-2016
 */
package org.w00tdevs.project.sonarviewer.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Project;

/**
 * The Interface TagRepository.
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
