package com.serv;

import java.io.Serializable;

/**
 * Service Layer's Functional Exception
 * 
 * @version<ul>
 *	<li>v1.0 : 01/2012 : besniergu : Creation
 *	</ul>
 */
public class FunctionalException extends Exception{
	/** @see Serializable **/
	private static final long serialVersionUID = 2258751413359615311L;

	/**
	 * Constructor called by CINRJ Service Distribution
	 * 
	 * @param message
	 * exception message
	 */
	public FunctionalException( String message ){
		super(message);
	}
	
	/**
	 * @param message
	 * exception message
	 * 
	 * @param e
	 * exception
	 */
	public FunctionalException( String message, Throwable e ){
		super(message,e);
	}
}
