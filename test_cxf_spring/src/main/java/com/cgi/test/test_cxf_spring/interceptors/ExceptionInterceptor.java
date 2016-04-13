package com.cgi.test.test_cxf_spring.interceptors;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

public class ExceptionInterceptor extends AbstractSoapInterceptor {


	/** the name space **/
	private static final String TNS  = "http://service.wkf.tgvwkf.bnppa.com/";


	/** the specific error code **/
	private static int errorCode = 111;


	public ExceptionInterceptor() { 
		super(Phase.PRE_LOGICAL); 
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleMessage(SoapMessage message) throws Fault {

		Fault fault = (Fault) message.getContent(Exception.class);
		if(fault != null && fault.getCause() != null) {
			System.out.println("ExceptionInterceptor => "+fault.getCause().getMessage());
			generateSoapFault(fault, fault.getCause().getMessage());
		}
	}

	/**
	 * Build SoapFault
	 * 
	 * @param fault the Fault
	 * @param message the String message
	 */
	private void generateSoapFault(Fault fault, String message) {
		fault.setFaultCode(createQName(errorCode)); 
		fault.setMessage(message);
	} 

	/**
	 * Create QName 
	 * 
	 * @param errorCode the specific error code
	 * @return the QName
	 */
	private static QName createQName(int errorCode) {
		return new QName(TNS, String.valueOf(errorCode));
	}

}
