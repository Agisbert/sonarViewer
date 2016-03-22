/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.database.dao
*	Class: IssueRepository.java
*	Author: Alberto
*	Last update: 18-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.business.database.entity.Issue;

/**
 * The Interface IssueRepository.
 */
public interface IssueRepository extends CrudRepository<Issue, String> {

}
