/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.api.domain
*	Class: SonarViewerCountMetadata.java
*	Author: Alberto
*	Last update: 18-sep-2016
*/
package org.w00tdevs.project.sonarviewer.api.domain;

/**
 * The Class SonarViewerCountMetadata.
 */
public class SonarViewerCountMetadata {

	/** The object type. */
	private SonarViewerCountMetadataType objectType;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new sonar viewer count metadata.
	 *
	 * @param objectType
	 *            the object type
	 * @param value
	 *            the value
	 */
	public SonarViewerCountMetadata(SonarViewerCountMetadataType objectType, String value) {
		super();
		this.objectType = objectType;
		this.value = value;
	}

	/**
	 * Gets the object type.
	 *
	 * @return the object type
	 */
	public SonarViewerCountMetadataType getObjectType() {
		return objectType;
	}

	/**
	 * Sets the object type.
	 *
	 * @param objectType
	 *            the new object type
	 */
	public void setObjectType(SonarViewerCountMetadataType objectType) {
		this.objectType = objectType;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * The Enum SonarViewerMetadataType.
	 */
	public enum SonarViewerCountMetadataType {

		/** The projects count. */
		PROJECTS_COUNT("projectsCount"),

		/** The profiles count. */
		PROFILES_COUNT("profilsCount"),

		/** The rules count. */
		RULES_COUNT("rulesCount"),

		/** The issues count. */
		ISSUES_COUNT("issuesCount");

		/** The text. */
		private String text;

		/**
		 * Instantiates a new sonar viewer metadata type.
		 *
		 * @param text
		 *            the text
		 */
		private SonarViewerCountMetadataType(String text) {
			this.text = text;
		}

		/**
		 * Gets the text.
		 *
		 * @return the text
		 */
		public String getText() {
			return text;
		}

		/**
		 * Sets the text.
		 *
		 * @param text
		 *            the new text
		 */
		public void setText(String text) {
			this.text = text;
		}

	}
}
