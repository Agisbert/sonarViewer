/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVIssueResourceService.java
*	Author: Alberto
*	Last update: 20-may-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;

/**
 * The Interface ProjectResourceService.
 */
@Path("issues")
public interface SVIssueResourceService {

	@Path("{issueId}")
	@GET
	SonarViewerIssue getSonarViewerIssue(@PathParam("issueId") Long issueId);

}
