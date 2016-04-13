package com.cgi.test.test_primefaces.spring.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActiveProfileConfiguration implements ServletContextListener {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveProfileConfiguration.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.info("Call for contextDestroyed ...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.info("Call for contextInitialized ...");
	}

}
