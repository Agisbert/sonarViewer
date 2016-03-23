/*
 *	    _  _                
 *	   / \/ \_|_ _| _     _ 
 *	\^/\_/\_/ |_(_|(/_\_/_> 
 *
 *	Project: sonarviewer-app
 *	Package: org.w00tdevs.project.sonarviewer.config
 *	Class: beansConfig.java
 *	Author: Alberto
 *	Last update: 23-mar-2016
 */
package org.w00tdevs.project.sonarviewer.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * The Class beansConfig.
 */
@Configuration
public class beansConfig {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(beansConfig.class);

	/** The resource loader. */
	@Autowired
	private ResourcePatternResolver resourceLoader;

	/**
	 * Dozer bean mapper.
	 *
	 * @return the mapper
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Bean
	public Mapper dozerBeanMapper() throws IOException {
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		// Set the custom mapping files
		dozerBeanMapper.setMappingFiles(Arrays.asList("dozerCustomMappingFiles/ProjectDozerMapper.xml",
				"dozerCustomMappingFiles/IssueDozerMapper.xml", "dozerCustomMappingFiles/RuleDozerMapper.xml"));
		// Set the custom converters if any
		LOG.info("Dozermapper created!");
		return dozerBeanMapper;
	}

	/**
	 * Rest template.
	 *
	 * @return the rest operations
	 */
	@Bean
	public RestOperations restTemplate() {
		// Using apache http impl
		RestTemplate restTemplate = new RestTemplate();
		LOG.info("RestTemplate created!");
		return restTemplate;
	}

	/**
	 * Jackson2 object mapper builder.
	 *
	 * @return the jackson2 object mapper builder
	 */
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		Jackson2ObjectMapperBuilder jacksonMapperJsonBuilder = Jackson2ObjectMapperBuilder.json();
		// Date format
		jacksonMapperJsonBuilder.dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		// Return the custom mapper;

		LOG.info("JacksonMapperJsonBuilder created!");
		return jacksonMapperJsonBuilder;
	}
}
