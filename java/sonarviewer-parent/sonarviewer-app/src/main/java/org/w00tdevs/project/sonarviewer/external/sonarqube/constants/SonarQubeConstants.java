/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.sonarqube.client.constants
*	Class: SonarQubeConstants.java
*	Author: Alberto
*	Last update: 16-mar-2016
*/
package org.w00tdevs.project.sonarviewer.external.sonarqube.constants;

/**
 * The Class SonarQubeConstants.
 */
public final class SonarQubeConstants {

	/**
	 * Instantiates a new sonar qube constants.
	 */
	private SonarQubeConstants() {

	}

	/**
	 * The Class IssuesSearch.
	 */
	public final class IssuesSearch {

		/**
		 * Instantiates a new issues search.
		 */
		private IssuesSearch() {

		}

		/** The Constant PATH. */
		public static final String PATH = "/api/issues/search";

		/** The Constant PROJECTKEY. */
		public static final String PROJECTKEY = "componentKeys";

		/** The Constant AUTHOR. */
		public static final String AUTHOR = "author";

		/** The Constant PAGE. */
		public static final String PAGE = "p";
	}

	/**
	 * The Class ProfilesSearch.
	 */
	public final class ProfilesSearch {

		/**
		 * Instantiates a new profiles search.
		 */
		private ProfilesSearch() {

		}

		/** The Constant PATH. */
		public static final String PATH = "/api/qualityprofiles/search?projectKey={projectKey}&active={active}";

		/** The Constant PROJECTKEY. */
		public static final String PROJECTKEY = "projectKey";

		/** The Constant ACTIVE. */
		public static final String ACTIVE = "active";

	}

	/**
	 * The Class RulesSearch.
	 */
	public final class RulesSearch {

		/**
		 * Instantiates a new rules search.
		 */
		private RulesSearch() {

		}

		/** The Constant PATH. */
		public static final String PATH = "/api/rules/search?qprofile={qprofile}&activation={activation}&p={p}";

		/** The Constant QPROFILE. */
		public static final String QPROFILE = "qprofile";

		/** The Constant ACTIVE. */
		public static final String ACTIVE = "activation";

		/** The Constant PAGE. */
		public static final String PAGE = "p";

	}

	/**
	 * The Class ProjectSearch.
	 */
	public final class ProjectSearch {

		/**
		 * Instantiates a new project search.
		 */
		private ProjectSearch() {

		}

		/** The Constant PATH. */
		public static final String PATH = "/api/projects/index?search={search}&format={format}";

		/** The Constant TERM. */
		public static final String TERM = "search";

		/** The Constant FORMAT. */
		public static final String FORMAT = "format";

		/** The Constant FORMAT_DEFAULT_VALUE. */
		public static final String FORMAT_DEFAULT_VALUE = "json";

	}
}
