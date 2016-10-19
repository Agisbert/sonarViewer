/*
*	    _  _                
*	   / \/ \_|_ _| _     _ 
*	\^/\_/\_/ |_(_|(/_\_/_> 
*
*	Project: sonarviewer-app
*	Package: org.w00tdevs.project.sonarviewer.config
*	Class: BeansConfig.java
*	Author: Alberto
*	Last update: 04-oct-2016
*/
package org.w00tdevs.project.sonarviewer.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Path;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.spring.JaxRsConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.w00tdevs.project.sonarviewer.config.cxf.CustomOutInterceptor;
import org.w00tdevs.project.sonarviewer.config.cxf.SonarViewerExceptionMapper;
import org.w00tdevs.project.sonarviewer.dozer.CustomMapper;
import org.w00tdevs.project.sonarviewer.dozer.MyCustomFieldMapper;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.SonarQubeClient;
import org.w00tdevs.project.sonarviewer.external.sonarqube.service.impl.SonarQubeClientImpl;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * The Class beansConfig.
 */
@Configuration
@EnableScheduling
@Import(JaxRsConfig.class)
public class BeansConfig {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(BeansConfig.class);

	@Bean
	public ApplicationParams applicationParams() {
		return new ApplicationParams();
	}

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
				"dozerCustomMappingFiles/IssueDozerMapper.xml"));
		// Set the custom converters if any (Not yet)
		// Set the custom field Mapper (To avoid HIBERNATE lazy problems)
		dozerBeanMapper.setCustomFieldMapper(new MyCustomFieldMapper());
		LOG.info("Dozermapper created!");
		return dozerBeanMapper;
	}

	/**
	 * Dozer bean mapper.
	 *
	 * @return the mapper
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public CustomMapper customBeanMapper() throws IOException {
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		// Set the custom mapping files
		dozerBeanMapper.setMappingFiles(Arrays.asList("dozerMiniMappingsFiles/IssueDozerMapper.xml"));
		LOG.info("Dozermapper created!");
		return new CustomMapper(dozerBeanMapper);
	}

	@Bean
	public SonarQubeClient sonarQubeClient() {
		return new SonarQubeClientImpl(applicationParams().SONAR_SERVER_URL);

	}

	/**
	 * Servlet registration bean.
	 *
	 * @param context
	 *            the context
	 * @return the servlet registration bean
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
		return new ServletRegistrationBean(new CXFServlet(), "/services/*");
	}

	/**
	 * Rs server.
	 *
	 * @return the server
	 */
	@Bean
	public Server rsServer(ApplicationContext context) {
		// Find all beans annotated with @Path
		List<Object> serviceBeans = Arrays.asList((context.getBeansWithAnnotation(Path.class).values()));
		LOG.info("Registering service beans: " + serviceBeans);
		// Jackson json provider
		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
		// Exception mapper
		SonarViewerExceptionMapper exceptionMapper = new SonarViewerExceptionMapper();
		List<Object> providers = Arrays.asList(jsonProvider, exceptionMapper);
		LOG.info("Registering providers beans: " + serviceBeans);
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setServiceBeans(serviceBeans);
		endpoint.setProviders(providers);
		endpoint.setAddress("/");

		Server cxfServer = endpoint.create();

		// Add interceptor for logging request
		if (LOG.isDebugEnabled()) {
			cxfServer.getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
		}
		// Add interceptor for logging response
		if (LOG.isDebugEnabled()) {
			cxfServer.getEndpoint().getOutInterceptors().add(new LoggingOutInterceptor());
		}
		cxfServer.getEndpoint().getOutInterceptors().add(new CustomOutInterceptor());

		return cxfServer;
	}
}
