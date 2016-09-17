/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.dozer
*	Class: ListTransformer.java
*	Author: Alberto
*	Last update: 01-abr-2016
*/
package org.w00tdevs.project.sonarviewer.dozer;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class ListTransformer.
 */
@Service
public class ListTransformer {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ListTransformer.class);

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
		LOG.info("Transforming list to " + destinationListType.getName());
		// Ultra fast IMPL
		List<T> destinationList = origin.parallelStream().map(p -> dozerMapper.map(p, destinationListType))
				.collect(Collectors.toList());
		// List<T> destinationList = new ArrayList<T>();
		// for (U object : origin) {
		// destinationList.add(dozerMapper.map(object, destinationListType));
		// }
		LOG.info("Transformation DONE ");
		return destinationList;

	}
}