/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVIssueResourceServiceImpl.java
*	Author: Alberto
*	Last update: 17-sep-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.webservice.SVIssueResourceService;

public class SVIssueResourceServiceImpl implements SVIssueResourceService {

	@Autowired
	private IssueService issueService;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	@Override
	public SonarViewerIssue getSonarViewerIssue(Long issueId) {
		SVIssue svIssue = issueService.getIssue(issueId);
		return dozerMapper.map(svIssue, SonarViewerIssue.class);
	}

}
