/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer
 *	Class: SpringBootApplication.java
 *	Author: Alberto
 *	Last update: 11-mar-2016
 */
package org.w00tdevs.project.sonarviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class SpringBootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootApplication.class, args);
	}

}