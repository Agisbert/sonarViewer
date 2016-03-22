/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.database.dao
*	Class: TagRepository.java
*	Author: Alberto
*	Last update: 10-mar-2016
*/
package org.w00tdevs.project.sonarviewer.business.database.dao;

import org.springframework.data.repository.CrudRepository;
import org.w00tdevs.project.sonarviewer.business.database.entity.Tag;

/**
 * The Interface TagRepository.
 */
public interface TagRepository extends CrudRepository<Tag, String> {

}
