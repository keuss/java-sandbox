package com.pres;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;

/**
 * Util to add global error in Faces Error Context
 * 
 */
public final class FacesMessageUtil{
	/**
	 * Contains only static method so private constructor.
	 */
	private FacesMessageUtil(){
	}
	
	private final static String TECHNICAL_ERROR = "Technical Error";
	
	/**
	 * @param logger
	 * to log error
	 * 
	 * @param e
	 * exception to log and add to FacesContext
	 */
	public static void addGlobalError( final Logger logger, final Exception e ){
		logger.error( e.getClass().getSimpleName(), e );
		
		final FacesContext facesCtx = FacesContext.getCurrentInstance();
		
		String message = e.getMessage();
		if( e instanceof RuntimeException ){
			message = TECHNICAL_ERROR;
		}
		
		FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, message, message );
		facesCtx.addMessage( null, msg );
	}
}
