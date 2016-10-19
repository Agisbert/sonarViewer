/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-database
*	Package: org.w00tdevs.project.sonarviewer.database.dao
*	Class: IssueRepository.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Issue;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;

/**
 * The Interface IssueRepository.
 */
public interface IssueRepository extends CrudRepository<Issue, Long> {

	/**
	 * Find one by key.
	 *
	 * @param key
	 *            the key
	 * @return the issue
	 */
	Issue findOneByKey(String key);

	/**
	 * Find first by project order by creation date desc.
	 *
	 * @param project
	 *            the project
	 * @return the issue
	 */
	Issue findFirstByProjectOrderByCreationDateDesc(Project project);

	/**
	 * Find by project.
	 *
	 * @param project
	 *            the project
	 * @return the list
	 */
	List<Issue> findByProject(Project project);

	/**
	 * Find by project and rule profile.
	 *
	 * @param project
	 *            the project
	 * @param profile
	 *            the profile
	 * @return the list
	 */
	List<Issue> findByProjectAndRuleProfile(Project project, Profile profile);

	/**
	 * Find by project and rule.
	 *
	 * @param project
	 *            the project
	 * @param rule
	 *            the rule
	 * @return the list
	 */
	List<Issue> findByProjectAndRule(Project project, Rule rule);

	/**
	 * Find by rule profile.
	 *
	 * @param profile
	 *            the profile
	 * @return the list
	 */
	List<Issue> findByRuleProfile(Profile profile);

	/**
	 * Find by rule.
	 *
	 * @param rule
	 *            the rule
	 * @return the list
	 */
	List<Issue> findByRule(Rule rule);

}
