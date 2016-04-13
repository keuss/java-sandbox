package com.cgi.test.test_cxf_spring.bye.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cgi.test.test_cxf_spring.bye.bdt.ByeBDT;
import com.cgi.test.test_cxf_spring.bye.exception.ByeException;
import com.cgi.test.test_cxf_spring.bye.itf.ByeService;

@Service("byeservices")
public class ByeServiceImpl implements ByeService {

	public ByeBDT sayBye(ByeBDT byeBdt) throws ByeException {
		
		String msg = "sayBye => : " + byeBdt.getName() + " - " + byeBdt.getTexts();
		System.out.println(msg);
		
		ByeBDT bdt = new ByeBDT();
		bdt.setName("name : " + msg);
		bdt.setTexts(new ArrayList<String>(byeBdt.getTexts()));
		
		// test
		if(false)
			throw new ByeException("ByeException : WTF ????");
		
		return bdt;
	}



}
