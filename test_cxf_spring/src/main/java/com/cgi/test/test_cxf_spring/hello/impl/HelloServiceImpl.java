package com.cgi.test.test_cxf_spring.hello.impl;

import org.springframework.stereotype.Service;

import com.cgi.test.test_cxf_spring.hello.bdt.HelloBDT;
import com.cgi.test.test_cxf_spring.hello.exception.HelloException;
import com.cgi.test.test_cxf_spring.hello.itf.HelloService;

@Service("helloservices")
public class HelloServiceImpl implements HelloService {

	public String sayHi(HelloBDT helloBdt)
			throws HelloException {
		String msg = "sayHi => : " + helloBdt.getName() + " - " + helloBdt.getTexts();
		System.out.println(msg);
		//the  received message
		return msg;
	}

	

}
