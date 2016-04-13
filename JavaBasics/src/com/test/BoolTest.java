package com.test;

import java.util.Properties;

public class BoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		Boolean activeTrace = new Boolean("true");
		if(activeTrace) {
			System.out.println("activeTrace");
		} else {
			System.out.println("!activeTrace");
		}

	}

}
