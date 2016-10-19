/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.service.impl
*	Class: IssueServiceImpl.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.apache.commons.collections.IteratorUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.database.dao.IssueRepository;
import org.w00tdevs.project.sonarviewer.database.dao.RuleRepository;
import org.w00tdevs.project.sonarviewer.database.entity.Issue;
import org.w00tdevs.project.sonarviewer.database.entity.Profile;
import org.w00tdevs.project.sonarviewer.database.entity.Project;
import org.w00tdevs.project.sonarviewer.database.entity.Rule;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVProfile;
import org.w00tdevs.project.sonarviewer.domain.SVProject;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.IssuesSearchResponse;
import org.w00tdevs.project.sonarviewer.external.sonarqube.domain.SonarQubeIssue;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.service.IssueService;

/**
 * The Class IssueServiceImpl.
 */
@Service
@Transactional
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

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.business.service.IssueService#
	 * importIssuesFromProject(java.lang.String)
	 */
	@Override
	public List<SVIssue> importIssuesFromProject(SVProject svProject) {
		// Retrieve first list of issues
		LOG.info("Importing ISSUES from Project " + svProject);
		IssuesSearchResponse isResponse = sonarQubeClient.getIssues(svProject.getKey(), 1);
		// Innitialize the list with the first pack of rules
		List<SonarQubeIssue> sonarQubeIssues = isResponse.getIssues();
		// Iterate the pages
		// for (int i = 1; i < isResponse.getNumberOfPages(); i++) {
		// LOG.info("Importing page " + (i + 1) + " of " +
		// isResponse.getNumberOfPages() + " from Project "
		// + svProject);
		// IssuesSearchResponse rsResponseAux =
		// sonarQubeClient.getIssues(svProject.getKey(), i + 1);
		// // Populate the list with the following list of issues
		// sonarQubeIssues.addAll(rsResponseAux.getIssues());
		// }

		// Super FAST implementation with streams
		sonarQubeIssues.addAll(IntStream.range(1, isResponse.getNumberOfPages() - 1).parallel().mapToObj(i -> {
			LOG.info("Importing page " + (i + 1) + " of " + isResponse.getNumberOfPages() + " from Project "
					+ svProject);
			return sonarQubeClient.getIssues(svProject.getKey(), i + 1);
		}).flatMap(p -> p.getIssues().stream()).collect(Collectors.toList()));

		LOG.info("Retrieved " + sonarQubeIssues.size() + " ISSUES from Project " + svProject);
		List<Issue> issues = listTransformer.transform(sonarQubeIssues, Issue.class);
		// Save the issue if exist
		List<Issue> savedIssues = saveIssuesIfNotExists(issues, dozerMapper.map(svProject, Project.class));
		LOG.info("Saved " + savedIssues.size() + " ISSUES from Project " + svProject);
		// Transform it to the domain
		List<SVIssue> savedSVIssues = listTransformer.transform(savedIssues, SVIssue.class);
		return savedSVIssues;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.IssueService#
	 * importIssuesFromProjectSinceDate(org.w00tdevs.project.sonarviewer.domain.
	 * SVProject, java.util.Date)
	 */
	@Override
	public List<SVIssue> importIssuesFromProjectSinceDate(SVProject svProject, Date date) {
		// Retrieve first list of issues
		LOG.info("Importing ISSUES from Project " + svProject);
		IssuesSearchResponse isResponse = sonarQubeClient.getIssues(svProject.getKey(), 1);

		List<SonarQubeIssue> sonarQubeIssues = isResponse.getIssues();
		// Super FAST implementation with streams
		sonarQubeIssues.addAll(IntStream.range(1, isResponse.getNumberOfPages() - 1).parallel().mapToObj(i -> {
			LOG.info("Importing page " + (i + 1) + " of " + isResponse.getNumberOfPages() + " from Project "
					+ svProject);
			return sonarQubeClient.getIssues(svProject.getKey(), i + 1);
		}).flatMap(p -> p.getIssues().stream()).collect(Collectors.toList()));

		LOG.info("Retrieved " + sonarQubeIssues.size() + " ISSUES from Project " + svProject);
		List<Issue> issues = listTransformer.transform(sonarQubeIssues, Issue.class);
		// Save the issue if exist
		List<Issue> savedIssues = saveIssuesIfNotExists(issues, dozerMapper.map(svProject, Project.class));
		LOG.info("Saved " + savedIssues.size() + " ISSUES from Project " + svProject);
		// Transform it to the domain
		List<SVIssue> savedSVIssues = listTransformer.transform(savedIssues, SVIssue.class);
		return savedSVIssues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.IssueService#
	 * getLastCreationDateFromProject(org.w00tdevs.project.sonarviewer.domain.
	 * SVProject)
	 */
	@Override
	public Date getLastCreationDateFromProject(SVProject svProject) {
		Project project = dozerMapper.map(svProject, Project.class);
		Issue lastIssue = issueRepository.findFirstByProjectOrderByCreationDateDesc(project);
		return lastIssue.getUpdateDate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.IssueService#
	 * getIssuesFromProject(org.w00tdevs.project.sonarviewer.domain.SVProject)
	 */
	@Override
	public List<SVIssue> getIssuesFromProject(SVProject svProject) {
		Project project = dozerMapper.map(svProject, Project.class);
		List<Issue> projectIssues = issueRepository.findByProject(project);
		List<SVIssue> svIssues = listTransformer.transform(projectIssues, SVIssue.class);
		return svIssues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.IssueService#
	 * getListOfIssuesOfProjectAndProfile(org.w00tdevs.project.sonarviewer.
	 * domain.SVProfile)
	 */
	@Override
	public List<SVIssue> getIssuesFromProjectAndProfile(SVProject svProject, SVProfile svProfile) {
		Project project = dozerMapper.map(svProject, Project.class);
		Profile profile = dozerMapper.map(svProfile, Profile.class);
		List<Issue> projectIssues = issueRepository.findByProjectAndRuleProfile(project, profile);
		List<SVIssue> svIssues = listTransformer.transform(projectIssues, SVIssue.class);
		return svIssues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.IssueService#
	 * getListOfIssuesOfProjectAndRule(org.w00tdevs.project.sonarviewer.domain.
	 * SVRule)
	 */
	@Override
	public List<SVIssue> getIssuesFromProjectAndRule(SVProject svProject, SVRule svRule) {
		Project project = dozerMapper.map(svProject, Project.class);
		Rule rule = dozerMapper.map(svRule, Rule.class);
		List<Issue> projectIssues = issueRepository.findByProjectAndRule(project, rule);
		List<SVIssue> svIssues = listTransformer.transform(projectIssues, SVIssue.class);
		return svIssues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.w00tdevs.project.sonarviewer.service.IssueService#getIssue(java.lang.
	 * Long)
	 */
	@Override
	public SVIssue getIssue(Long issueId) {
		Issue issue = issueRepository.findOne(issueId);
		return dozerMapper.map(issue, SVIssue.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.service.IssueService#
	 * getIssuesFromProfile(org.w00tdevs.project.sonarviewer.domain.SVProfile)
	 */
	@Override
	public List<SVIssue> getIssuesFromProfile(SVProfile svProfile) {
		Profile profile = dozerMapper.map(svProfile, Profile.class);
		List<Issue> projectIssues = issueRepository.findByRuleProfile(profile);
		List<SVIssue> svIssues = listTransformer.transform(projectIssues, SVIssue.class);
		return svIssues;
	}

	@Override
	public List<SVIssue> getAvailableIssues() {
		List<Issue> issues = IteratorUtils.toList(issueRepository.findAll().iterator());
		return listTransformer.transform(issues, SVIssue.class);
	}

	@Override
	public List<SVIssue> getIssuesFromRule(SVRule svRule) {
		Rule rule = dozerMapper.map(svRule, Rule.class);
		List<Issue> ruleIssues = issueRepository.findByRule(rule);
		return listTransformer.transform(ruleIssues, SVIssue.class);
	}

}
