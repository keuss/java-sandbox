package com.cgi.test.test_cxf_spring.bye.itf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.cgi.test.test_cxf_spring.bye.bdt.ByeBDT;
import com.cgi.test.test_cxf_spring.bye.exception.ByeException;


@WebService(targetNamespace = "http://itf.bye.test_cxf_spring.test.cgi.com/", 
name = "bye",
serviceName = "byeservices")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface ByeService {
	
	/**
	 * @param byeBdt
	 * @return a ByeBDT
	 * @throws ByeException
	 */
	@WebMethod
	ByeBDT sayBye(@WebParam(name = "byeBdt")ByeBDT byeBdt) throws ByeException;

}
