package com.cgi.test.test_cxf_spring.hello.exception;

import javax.xml.ws.WebFault;


@WebFault(name = "HelloServiceException", targetNamespace = "http://itf.hello.test_cxf_spring.test.cgi.com/")
public class HelloException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6930052888645856952L;


	/**
	 * 
	 * @param message
	 * exception message
	 */
	public HelloException( final String message ){
		super(message);
	}

	/**
	 * @param message
	 * exception message
	 * 
	 * @param e
	 * exception
	 */
	public HelloException( final String message, final Throwable e ){
		super(message,e);
	}


}
