/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.config.cxf
*	Class: CustomOutInterceptor.java
*	Author: Alberto
*	Last update: 04-oct-2016
*/
package org.w00tdevs.project.sonarviewer.config.cxf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

public class CustomOutInterceptor extends AbstractOutDatabindingInterceptor {

	public CustomOutInterceptor() {
		super(Phase.MARSHAL);
	}

	@Override
	public void handleMessage(Message outMessage) {
		@SuppressWarnings("unchecked")
		Map<String, List<String>> headers = (Map<String, List<String>>) outMessage.get(Message.PROTOCOL_HEADERS);
		if (headers == null) {
			headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
			outMessage.put(Message.PROTOCOL_HEADERS, headers);
		}
		headers.put("Access-Control-Allow-Origin", Arrays.asList("*"));
	}
}