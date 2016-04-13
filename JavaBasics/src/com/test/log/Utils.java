package com.test.log;

import java.util.logging.Logger;

public class Utils {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public void doSomething() {
		// ... more code

		// now we demo the logging
		//System.out.println(LOGGER.getLevel().getName());
		LOGGER.severe("severe Log");
		LOGGER.warning("warning Log");
		LOGGER.info("info Log");
		LOGGER.finest("finest Log : Really not important");

	}

}
