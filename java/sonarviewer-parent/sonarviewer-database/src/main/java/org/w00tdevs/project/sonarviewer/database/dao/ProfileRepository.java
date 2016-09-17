/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-database
*	Package: org.w00tdevs.project.sonarviewer.database.dao
*	Class: ProfileRepository.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;

/**
 * The Interface ProfileRepository.
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {

	/**
	 * Find one by key.
	 *
	 * @param key
	 *            the key
	 * @return the profile
	 */
	Profile findOneByKey(String key);

	/**
	 * Find by projects containing.
	 *
	 * @param project
	 *            the project
	 * @return the list
	 */
	List<Profile> findByProjectsContaining(Project project);

}
