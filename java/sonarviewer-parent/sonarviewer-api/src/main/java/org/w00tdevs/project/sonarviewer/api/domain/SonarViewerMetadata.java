/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerMetadata.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

import java.util.List;

/**
 * The Class SonarViewerObjectMetadata.
 */
public class SonarViewerMetadata {

	private SonarViewerApiObject object;

	List<SonarViewerCountMetadata> metadataList;

	public SonarViewerMetadata(SonarViewerApiObject object) {
		super();
		this.object = object;
	}

	public SonarViewerApiObject getObject() {
		return object;
	}

	public void setObject(SonarViewerApiObject object) {
		this.object = object;
	}

	public List<SonarViewerCountMetadata> getMetadataList() {
		return metadataList;
	}

	public void setMetadataList(List<SonarViewerCountMetadata> metadataList) {
		this.metadataList = metadataList;
	}

}
