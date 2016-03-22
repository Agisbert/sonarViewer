/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.business.service.impl
*	Class: IssueServiceImpl.java
*	Author: Alberto
*	Last update: 22-mar-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.database.dao.IssueRepository;
import org.w00tdevs.project.sonarviewer.database.dao.RuleRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Issue;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.IssuesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeIssue;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.IssueService;

/**
 * The Class IssueServiceImpl.
 */
public class IssueServiceImpl implements IssueService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(IssueServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The issue repository. */
	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private RuleRepository ruleRepository;

	/** The list transformer. */
	@Autowired
	private ListTransformer listTransformer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.business.service.IssueService#
	 * importIssuesFromProject(java.lang.String)
	 */
	@Override
	public Long importIssuesFromProject(String projectKey) {
		// Retrieve first list of issues
		LOG.info("Importing ISSUES from Project " + projectKey);
		IssuesSearchResponse isResponse = sonarQubeClient.getIssues(projectKey, 1);
		// Innitialize the list with the first pack of rules
		List<SonarQubeIssue> sonarQubeIssues = isResponse.getIssues();
		// Iterate the pages
		for (int i = 0; i < isResponse.getNumberOfPages(); i++) {
			IssuesSearchResponse rsResponseAux = sonarQubeClient.getIssues(projectKey, i + 1);
			// Populate the list with the following list of issues
			sonarQubeIssues.addAll(rsResponseAux.getIssues());
		}
		LOG.info("Retrieved " + sonarQubeIssues.size() + " ISSUES from Project " + projectKey);
		List<Issue> issues = listTransformer.transform(sonarQubeIssues, Issue.class);
		// Save the issue if exist
		List<Issue> savedIssues = IteratorUtils.toList(issueRepository.save(issues).iterator());
		LOG.info("Saved " + savedIssues.size() + " ISSUES from Project " + projectKey);
		return Long.valueOf(savedIssues.size());
	}

}
