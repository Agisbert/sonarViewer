/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.dao
*	Class: RuleRepository.java
*	Author: Alberto
*	Last update: 10-abr-2016
*/
package org.w00tdevs.project.sonarviewer.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;

/**
 * The Interface RuleRepository.
 */
public interface RuleRepository extends CrudRepository<Rule, Long> {

	/**
	 * Find one by key.
	 *
	 * @param key
	 *            the key
	 * @return the rule
	 */
	Rule findOneByKey(String key);

	/**
	 * Find by profile.
	 *
	 * @param profile
	 *            the profile
	 * @return the list
	 */
	List<Rule> findByProfile(Profile profile);

}
