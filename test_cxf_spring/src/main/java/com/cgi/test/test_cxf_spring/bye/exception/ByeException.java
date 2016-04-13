package com.cgi.test.test_cxf_spring.bye.exception;

import javax.xml.ws.WebFault;


@WebFault(name = "ByeServiceException", targetNamespace = "http://itf.bye.test_cxf_spring.test.cgi.com/")
public class ByeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6930050288645856952L;


	/**
	 * 
	 * @param message
	 * exception message
	 */
	public ByeException( final String message ){
		super(message);
	}

	/**
	 * @param message
	 * exception message
	 * 
	 * @param e
	 * exception
	 */
	public ByeException( final String message, final Throwable e ){
		super(message,e);
	}


}
