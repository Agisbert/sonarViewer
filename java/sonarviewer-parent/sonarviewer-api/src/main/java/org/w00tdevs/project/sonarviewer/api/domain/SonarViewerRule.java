/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-api
*	Package: org.w00tdevs.project.sonarviewer.domain
*	Class: SonarViewerRule.java
*	Author: Alberto
*	Last update: 28-mar-2016
*/

package org.w00tdevs.project.sonarviewer.api.domain;

import java.util.Date;
import java.util.List;

/**
 * The Class Rule.
 */
public class SonarViewerRule {

	/** The rule id. */
	private Long ruleId;

	/** The key. */
	private String key;

	/** The repo. */
	private String repo;

	/** The name. */
	private String name;

	/** The created at. */
	private Date createdAt;

	/** The html desc. */
	private String htmlDesc;

	/** The severity. */
	private String severity;

	/** The status. */
	private String status;

	/** The internal key. */
	private String internalKey;

	/** The is template. */
	private Boolean isTemplate;

	/** The tags. */
	private List<String> tags;

	/** The lang. */
	private String lang;

	/** The lang name. */
	private String langName;

	/** The default debt char. */
	private String defaultDebtChar;

	/** The default debt sub char. */
	private String defaultDebtSubChar;

	/** The default debt rem fn type. */
	private String defaultDebtRemFnType;

	/** The default debt rem fn offset. */
	private String defaultDebtRemFnOffset;

	/** The debt overloaded. */
	private Boolean debtOverloaded;

	/** The debt rem fn type. */
	private String debtRemFnType;

	/** The debt rem fn offset. */
	private String debtRemFnOffset;

	/** The profile key. */
	private String profileKey;

}
