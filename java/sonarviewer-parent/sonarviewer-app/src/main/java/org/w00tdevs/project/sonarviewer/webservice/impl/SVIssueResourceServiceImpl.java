/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.webservice.impl
*	Class: SVIssueResourceServiceImpl.java
*	Author: Alberto
*	Last update: 14-oct-2016
*/
package org.w00tdevs.project.sonarviewer.webservice.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerCountMetadata.SonarViewerCountResourceType;
import org.w00tdevs.project.sonarviewer.api.domain.SonarViewerIssue;
import org.w00tdevs.project.sonarviewer.domain.SVIssue;
import org.w00tdevs.project.sonarviewer.service.IssueService;
import org.w00tdevs.project.sonarviewer.webservice.SVIssueResourceService;

/**
 * The Class SVIssueResourceServiceImpl.
 */
public class SVIssueResourceServiceImpl implements SVIssueResourceService {

	/** The issue service. */
	@Autowired
	private IssueService issueService;

	/** The dozer mapper. */
	@Autowired
	private Mapper dozerMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.webservice.SVIssueResourceService#
	 * getSonarViewerIssue(java.lang.Long)
	 */
	@Override
	public SonarViewerIssue getSonarViewerIssue(Long issueId) {
		SVIssue svIssue = issueService.getIssue(issueId);
		return dozerMapper.map(svIssue, SonarViewerIssue.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.w00tdevs.project.sonarviewer.webservice.SVIssueResourceService#
	 * getSonarViewerIssueCount()
	 */
	@Override
	public SonarViewerCountMetadata getSonarViewerIssueCount() {
		List<SVIssue> svIssues = issueService.getAvailableIssues();
		SonarViewerCountMetadata metadata = new SonarViewerCountMetadata(SonarViewerCountResourceType.ISSUES_COUNT,
				String.valueOf(svIssues.size()));
		return metadata;
	}

}
