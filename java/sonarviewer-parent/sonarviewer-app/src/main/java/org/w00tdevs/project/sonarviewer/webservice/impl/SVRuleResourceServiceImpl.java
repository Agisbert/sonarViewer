/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVRuleResourceServiceImpl.java
*	Author: Alberto
*	Last update: 13-may-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerRule;
import org.w00tdevs.project.sonarviewer.domain.SVRule;
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

}
