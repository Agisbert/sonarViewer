/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerMetadata.java
*	Author: Alberto
*	Last update: 30-sep-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

import java.util.List;

/**
 * The Class SonarViewerMetadata.
 */
public class SonarViewerMetadata {

	/** The resource. */
	private SonarViewerApiResource resource;

	/** The metadata list. */
	List<SonarViewerCountMetadata> metadataList;

	/**
	 * Instantiates a new sonar viewer metadata.
	 *
	 * @param resource
	 *            the resource
	 */
	public SonarViewerMetadata(SonarViewerApiResource resource) {
		super();
		this.resource = resource;
	}

	/**
	 * Gets the resource.
	 *
	 * @return the resource
	 */
	public SonarViewerApiResource getResource() {
		return resource;
	}

	/**
	 * Sets the resource.
	 *
	 * @param resource
	 *            the new resource
	 */
	public void setResource(SonarViewerApiResource resource) {
		this.resource = resource;
	}

	/**
	 * Gets the metadata list.
	 *
	 * @return the metadata list
	 */
	public List<SonarViewerCountMetadata> getMetadataList() {
		return metadataList;
	}

	/**
	 * Sets the metadata list.
	 *
	 * @param metadataList
	 *            the new metadata list
	 */
	public void setMetadataList(List<SonarViewerCountMetadata> metadataList) {
		this.metadataList = metadataList;
	}

}
