/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.dao
*	Class: ProjectRepository.java
*	Author: Alberto
*	Last update: 06-abr-2016
*/
package org.w00tdevs.project.sonarviewer.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Project;

/**
 * The Interface ProjectRepository.
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

	/**
	 * Find by name.
	 *
	 * @param project
	 *            the project
	 * @return the list
	 */
	List<Project> findByName(String project);

}
