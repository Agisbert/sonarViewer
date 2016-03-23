/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.dao
*	Class: IssueRepository.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Issue;

/**
 * The Interface IssueRepository.
 */
public interface IssueRepository extends CrudRepository<Issue, String> {

	Issue findOneByKey(String key);

}
