package com.cgi.test.test_cxf_spring.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgi.test.test_cxf_spring.hello.bdt.HelloBDT;
import com.cgi.test.test_cxf_spring.hello.exception.HelloException;
import com.cgi.test.test_cxf_spring.hello.itf.HelloService;
import com.cgi.test.test_cxf_spring.interceptors.WSSIDynamicCallBack;

public class ClientThread implements Runnable {

	/** spring ctx **/
	ClassPathXmlApplicationContext context = null;

	/** ws **/
	HelloService clientHello = null;

	/**
	 * Default constructor
	 */
	public ClientThread() {
		// init ws client
		context = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});
		// HelloService, each thred will call ws with the spring singleton helloClient
		clientHello = (HelloService)context.getBean("helloClient");
	}

	@Override
	public void run() {

		//test thread local user/password
		WSSIDynamicCallBack.setThreadIdentity(Thread.currentThread().getName()+"user", Thread.currentThread().getName()+"passw");

		//prepare ws param (BDT)
		HelloBDT hBDT = new HelloBDT();
		List<String> texts = new ArrayList<String>();
		texts.add(Thread.currentThread().getName()+"text1");
		texts.add(Thread.currentThread().getName()+"text2");
		hBDT.setName(Thread.currentThread().getName()+"DaKESS");
		hBDT.setTexts(texts);

		try {

			System.out.println("ClientThread call for clientHello ...");
			String response = clientHello.sayHi(hBDT);
			System.out.println("ClientThread ResponseHello: " + response);

		} catch (HelloException e) {
			System.err.println("HelloException in ClientThread => " + Thread.currentThread().getName()  + " - " + e.getMessage());
		} catch (SOAPFaultException e) {
			System.err.println("SOAPFaultException in ClientThread => " + Thread.currentThread().getName()  + " - " + e.getFault().getFaultCode() + " - " + e.getFault().getFaultString());
		}

	}


}
