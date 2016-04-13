package com.test.log;

import java.util.logging.Logger;

public class Utils2 {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	
	
	public void doSomething2() {
		// ... more code

		// now we demo the logging
		LOGGER.severe("severe Log 2");
		LOGGER.warning("warning Log 2");
		LOGGER.info("info Log 2");
		LOGGER.finest("finest Log : Really not important 2");

	}

}
