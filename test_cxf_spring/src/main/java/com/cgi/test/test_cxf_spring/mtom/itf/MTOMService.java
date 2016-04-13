package com.cgi.test.test_cxf_spring.mtom.itf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.cgi.test.test_cxf_spring.mtom.bdt.DataBDT;


@WebService(targetNamespace = "http://itf.mtom.test_cxf_spring.test.cgi.com/", 
name = "mtom",
serviceName = "mtomservices")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface MTOMService {
	

	@WebMethod
	String sendData(@WebParam(name = "mtomBdt")DataBDT dataBDT);

}
