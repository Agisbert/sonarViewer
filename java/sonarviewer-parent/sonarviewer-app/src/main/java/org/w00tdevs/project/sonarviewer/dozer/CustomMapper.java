/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.dozer
*	Class: CustomMapper.java
*	Author: Alberto
*	Last update: 02-oct-2016
*/
package org.w00tdevs.project.sonarviewer.dozer;

import org.dozer.Mapper;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w00tdevs.project.sonarviewer.config.BeansConfig;

/**
 * The Class CustomMapper.
 */
public class CustomMapper implements Mapper {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(BeansConfig.class);

	/** The dozer mapper. */
	private Mapper dozerMapper;

	/**
	 * Instantiates a new custom mapper.
	 *
	 * @param mappingFilesPath
	 *            the mapping files path
	 */
	public CustomMapper(Mapper mapper) {
		dozerMapper = mapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.Mapper#map(java.lang.Object, java.lang.Class)
	 */
	@Override
	public <T> T map(Object source, Class<T> destinationClass) throws MappingException {
		return dozerMapper.map(source, destinationClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.Mapper#map(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void map(Object source, Object destination) throws MappingException {
		dozerMapper.map(source, destination);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.Mapper#map(java.lang.Object, java.lang.Class,
	 * java.lang.String)
	 */
	@Override
	public <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException {
		return dozerMapper.map(source, destinationClass, mapId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.Mapper#map(java.lang.Object, java.lang.Object,
	 * java.lang.String)
	 */
	@Override
	public void map(Object source, Object destination, String mapId) throws MappingException {
		dozerMapper.map(source, destination, mapId);
	}

}
