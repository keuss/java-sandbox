package com.cgi.test.test_cxf_spring.interceptors;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

public class FaultInterceptor extends AbstractSoapInterceptor  {

	public FaultInterceptor() {
		super(Phase.RECEIVE);
	}


	@Override
	public void handleMessage(SoapMessage message) throws Fault {


		Object codeError = message.get("abbas");
		System.out.println("Call for FaultInterceptor codeError:" + codeError);

//		Exchange e = message.getExchange();
//		System.out.println(e);
//		LoadingByteArrayOutputStream soapMessage = message.getContent(LoadingByteArrayOutputStream.class); 
//		System.out.println(soapMessage);
//		Message msg = message.getExchange().getInFaultMessage();
//		System.out.println(msg);
//		OutputStream out = msg.getContent(OutputStream.class);
//		System.out.println(out);
		
		Fault fault = (Fault) message.getContent(Fault.class);
		System.out.println("fault:"+fault.getFaultCode().getLocalPart());

	}

}
