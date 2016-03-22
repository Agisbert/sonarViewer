/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.dozer
*	Class: ListTransformer.java
*	Author: Alberto
*	Last update: 14-mar-2016
*/
package org.w00tdevs.project.sonarviewer.dozer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class ListTransformer.
 */
@Service
public class ListTransformer {

	/** The dozer bean mapper. */
	@Autowired
	private Mapper dozerMapper;

	/**
	 * Transform.
	 *
	 * @param <T>
	 *            the generic type
	 * @param origin
	 *            the origin
	 * @param destinationListType
	 *            the destination list type
	 * @return the list
	 */
	public <T, U> List<T> transform(List<U> origin, Class<T> destinationListType) {
		List<T> destinationList = new ArrayList<T>();
		for (U object : origin) {
			destinationList.add(dozerMapper.map(object, destinationListType));
		}
		return destinationList;

	}
}