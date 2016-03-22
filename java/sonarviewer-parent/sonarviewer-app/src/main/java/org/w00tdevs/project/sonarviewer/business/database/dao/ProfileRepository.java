/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.database.dao
*	Class: ProfileRepository.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.business.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.business.database.entity.Rule;

/**
 * The Interface ProfileRepository.
 */
public interface ProfileRepository extends CrudRepository<Profile, String> {

	/**
	 * Find one by key.
	 *
	 * @param key
	 *            the key
	 * @return the rule
	 */
	Rule findOneByKey(String key);

}
