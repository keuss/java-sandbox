package com.test.log;


import java.io.IOException;

public class MyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Utils tester = new Utils();
		Utils2 tester2 = new Utils2();
		try {
			MyLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating the log files");
		}
		tester.doSomething();
		tester2.doSomething2();

	}

}
