package com.cgi.test.test_cxf_spring.hello.itf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.cgi.test.test_cxf_spring.hello.bdt.HelloBDT;
import com.cgi.test.test_cxf_spring.hello.exception.HelloException;

@WebService(targetNamespace = "http://itf.hello.test_cxf_spring.test.cgi.com/", 
name = "hello",
serviceName = "helloservices")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface HelloService {
	

	/**
	 * @param helloBdt
	 * @return a string
	 * @throws HelloException
	 */
	@WebMethod
	String sayHi(@WebParam(name = "helloBdt")HelloBDT helloBdt) throws HelloException;
}
