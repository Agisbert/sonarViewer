/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.config.cxf
*	Class: SonarViewerExceptionMapper.java
*	Author: Alberto
*	Last update: 17-sep-2016
*/
package org.w00tdevs.project.sonarviewer.config.cxf;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerError;

/**
 * The Class SonarViewerExceptionMapper.
 */
public class SonarViewerExceptionMapper implements ExceptionMapper<Exception> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(Exception ex) {
		// convert to Response
		SonarViewerError sonarViewerError = new SonarViewerError();
		sonarViewerError.setErrorType("ERROR");
		sonarViewerError.setErrorMessage(ex.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(sonarViewerError).build();
	}
}
