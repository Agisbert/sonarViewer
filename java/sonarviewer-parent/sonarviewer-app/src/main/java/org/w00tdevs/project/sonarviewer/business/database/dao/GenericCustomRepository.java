/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.business.database.dao
 *	Class: GenericCustomRepository.java
 *	Author: Alberto
 *	Last update: 22-mar-2016
 */
package org.w00tdevs.project.sonarviewer.business.database.dao;

import java.util.List;

/**
 * The Interface GenericCustomRepository.
 *
 * @param <T>
 *            the generic type
 */
public interface GenericCustomRepository<T> {

	/**
	 * Save if not exists.
	 *
	 * @param <T>
	 *            the generic type
	 * @param entities
	 *            the entities
	 * @return the list
	 */
	List<T> saveIfNotExists(List<T> entities);
}
