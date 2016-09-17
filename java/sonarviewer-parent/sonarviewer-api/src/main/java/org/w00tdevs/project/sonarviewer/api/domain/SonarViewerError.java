/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerError.java
*	Author: Alberto
*	Last update: 06-jul-2016
*/

package org.w00tdevs.project.sonarviewer.api.domain;

/**
 * The Class SonarViewerError.
 */
public class SonarViewerError {

	/** The error type. */
	private String errorType;

	/** The error message. */
	private String errorMessage;

	/**
	 * Gets the issue id.
	 *
	 * @return the issue id
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * Sets the issue id.
	 *
	 * @param errorType
	 *            the new issue id
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage
	 *            the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
