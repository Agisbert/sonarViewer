/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-sonar-client
*	Package: org.w00tdevs.project.sonarviewer.external.sonarqube.constants
*	Class: SonarQubeConstants.java
*	Author: Alberto
*	Last update: 05-jul-2016
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

	/** The Constant DATE_FORMAT. */
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

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
		public static final String PATH = "/api/issues/search?componentKeys={componentKeys}&p={p}";

		/** The Constant PATH_DATE. */
		public static final String PATH_DATE = "/api/issues/search?componentKeys={componentKeys}&p={p}&createdAfter={createdAfter}";

		/** The Constant PATH_author. */
		public static final String PATH_author = "/api/issues/search?componentKeys={componentKeys}&p={p}&author={author}";

		/** The Constant PROJECTKEY. */
		public static final String PROJECTKEY = "componentKeys";

		/** The Constant AUTHOR. */
		public static final String AUTHOR = "author";

		/** The Constant PAGE. */
		public static final String PAGE = "p";

		/** The Constant CREATEDAFTER. */
		public static final String CREATEDAFTER = "createdAfter";
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

		/** The Constant PATH. sonar version 5.2 */
		public static final String PATH = "/api/qualityprofiles/search?projectKey={projectKey}&active={active}";

		// /** The Constant PATH. sonar version 5.1.2 */
		// public static final String PATH =
		// "/api/profiles/list?project={projectKey}";

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
