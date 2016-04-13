package com.cgi.test.test_primefaces.spring.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

public class PropertySourcesAppCtxInitializer implements
ApplicationContextInitializer<ConfigurableApplicationContext> {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySourcesAppCtxInitializer.class);

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		try {
			LOGGER.info("Adding some additional property sources ...");
			String profileActive = System.getProperty("spring.profiles.active");
			LOGGER.info("profile spring.profiles.active = [{}]", profileActive);
			
			if(profileActive != null && "local".equals(profileActive)) {
				// local configuration
				environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:db-"+profileActive+".properties"));
				environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:other-"+profileActive+".properties"));
				LOGGER.info("{} properties loaded", profileActive);
			} else {
				profileActive = "prod";
				// default => production
				environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:db-"+profileActive+".properties"));
				environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:other-"+profileActive+".properties"));
				LOGGER.info("{} properties loaded", profileActive);
			}
			
			//TEST to remove FIXME
			LOGGER.info("db.driver => [{}]", environment.getProperty("db.driver"));
			
		} catch (IOException e) {
			// it's ok if the file is not there. we will just log that info.
			LOGGER.info("didn't find good properties in classpath so not loading it in the AppContextInitialized");
		}

	}

}
