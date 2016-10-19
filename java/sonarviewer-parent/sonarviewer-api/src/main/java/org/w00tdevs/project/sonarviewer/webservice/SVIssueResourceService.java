/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.webservice
*	Class: SVIssueResourceService.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;

/**
 * The Interface SVIssueResourceService.
 */
@Path("issues")
public interface SVIssueResourceService {

	/**
	 * Gets the sonar viewer issue count.
	 *
	 * @return the sonar viewer issue count
	 */
	@Path("count")
	@GET
	SonarViewerCountMetadata getSonarViewerIssueCount();

	/**
	 * Gets the sonar viewer issue.
	 *
	 * @param issueId
	 *            the issue id
	 * @return the sonar viewer issue
	 */
	@Path("{issueId}")
	@GET
	SonarViewerIssue getSonarViewerIssue(@PathParam("issueId") Long issueId);

}
