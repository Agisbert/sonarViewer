/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.service.impl
 *	Class: IssueServiceImpl.java
 *	Author: Alberto
 *	Last update: 22-mar-2016
 */
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.database.dao.IssueRepository;
import org.w00tdevs.project.sonarviewer.database.dao.RuleRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Issue;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.IssuesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeIssue;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.IssueService;

/**
 * The Class IssueServiceImpl.
 */
@Service
public class IssueServiceImpl implements IssueService {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(IssueServiceImpl.class);

	/** The sonar qube client. */
	@Autowired
	private SonarQubeClient sonarQubeClient;

	/** The issue repository. */
	@Autowired
	private IssueRepository issueRepository;

	/** The rule repository. */
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
	public List<Issue> importIssuesFromProject(Project project) {
		// Retrieve first list of issues
		LOG.info("Importing ISSUES from Project " + project);
		IssuesSearchResponse isResponse = sonarQubeClient.getIssues(project.getKey(), 1);
		// Innitialize the list with the first pack of rules
		List<SonarQubeIssue> sonarQubeIssues = isResponse.getIssues();
		// Iterate the pages
		for (int i = 0; i < isResponse.getNumberOfPages(); i++) {
			LOG.info("Importing page " + (i + 1) + " of " + isResponse.getNumberOfPages() + " from Project " + project);
			IssuesSearchResponse rsResponseAux = sonarQubeClient.getIssues(project.getKey(), i + 1);
			// Populate the list with the following list of issues
			sonarQubeIssues.addAll(rsResponseAux.getIssues());
		}
		LOG.info("Retrieved " + sonarQubeIssues.size() + " ISSUES from Project " + project);
		List<Issue> issues = listTransformer.transform(sonarQubeIssues, Issue.class);
		// Save the issue if exist
		List<Issue> savedIssues = saveIssuesIfNotExists(issues, project);
		LOG.info("Saved " + savedIssues.size() + " ISSUES from Project " + project);
		return savedIssues;
	}

	/**
	 * Save issues if not exists.
	 *
	 * @param issues
	 *            the issues
	 * @param project
	 *            the project
	 * @return the list
	 */
	private List<Issue> saveIssuesIfNotExists(List<Issue> issues, Project project) {
		List<Issue> savedIssues = new ArrayList<Issue>();
		for (Issue issue : issues) {
			Issue savedIssue = issueRepository.findOneByKey(issue.getKey());
			if (savedIssue == null) {
				// Set the already saved profile.
				issue.setProject(project);
				// Set the retrieved rule from DB
				Rule savedRule = ruleRepository.findOneByKey(issue.getRule().getKey());
				issue.setRule(savedRule);
				// Save and add to the list of saved
				savedIssues.add(issueRepository.save(issue));
			}
		}
		return savedIssues;
	}

}
