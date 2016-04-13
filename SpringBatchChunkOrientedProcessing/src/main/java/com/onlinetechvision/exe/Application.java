package com.onlinetechvision.exe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinetechvision.spring.batch.BatchProcessStarter;

/**
 * Application Class starts the application.
 * 
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	/**
	 * Starts the application
	 *
	 * @param  String[] args
	 *
	 */
	public static void main(String[] args) {
		logger.info("Strating Application ...");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		BatchProcessStarter batchProcessStarter = (BatchProcessStarter)appContext.getBean("batchProcessStarter");
		batchProcessStarter.start();
		logger.info("Application END");
	}

}
