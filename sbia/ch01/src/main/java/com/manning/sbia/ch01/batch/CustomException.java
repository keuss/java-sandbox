package com.manning.sbia.ch01.batch;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4906459909033284775L;
	
    public CustomException() {}

    public CustomException(String message) {
       super(message);
    }
}
