/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVRuleResourceServiceImpl.java
*	Author: Alberto
*	Last update: 15-oct-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata.SonarViewerCountResourceType;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
import org.w00tdevs.project.sonarviewer.dozer.ListTransformer;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.service.RuleService;
import org.w00tdevs.project.sonarviewer.webservice.SVRuleResourceService;

/**
 * The Class SVRuleResourceServiceImpl.
 */
@Service
public class SVRuleResourceServiceImpl implements SVRuleResourceService {

	/** The rule service. */
	@Autowired
	private RuleService ruleService;

	@Autowired
	private IssueService issueService;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private ListTransformer listTransformer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.webservice.SVRuleResourceService#
	 * getSonarViewerRule(java.lang.Long)
	 */
	@Override
	public SonarViewerRule getSonarViewerRule(Long ruleId) {
		SVRule svRule = ruleService.getRule(ruleId);
		return dozerMapper.map(svRule, SonarViewerRule.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.webservice.SVRuleResourceService#
	 * getSonarViewerRulesCount()
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerRulesCount() {
		List<SVRule> svRules = ruleService.getAvailableRules();
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(SonarViewerCountResourceType.RULES_COUNT,
				String.valueOf(svRules.size()));
		return metadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.webservice.SVRuleResourceService#
	 * getSonarViewerRuleIssues(java.lang.Long)
	 */
	@Override
	public List<SonarViewerIssue> getSonarViewerRuleIssues(Long ruleId) {
		SVRule svRule = ruleService.getRule(ruleId);
		List<SVIssue> svIssues = issueService.getIssuesFromRule(svRule);
		return listTransformer.transform(svIssues, SonarViewerIssue.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.webservice.SVRuleResourceService#
	 * getSonarViewerRuleIssuesCount(java.lang.Long)
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerRuleIssuesCount(Long ruleId) {
		SVRule svRule = ruleService.getRule(ruleId);
		List<SVIssue> svIssues = issueService.getIssuesFromRule(svRule);
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(SonarViewerCountResourceType.ISSUES_COUNT,
				String.valueOf(svIssues.size()));
		return metadata;
	}

}
