package com.cgi.test.test_cxf_spring.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgi.test.test_cxf_spring.bye.bdt.ByeBDT;
import com.cgi.test.test_cxf_spring.bye.exception.ByeException;
import com.cgi.test.test_cxf_spring.bye.itf.ByeService;
import com.cgi.test.test_cxf_spring.hello.bdt.HelloBDT;
import com.cgi.test.test_cxf_spring.hello.itf.HelloService;
import com.cgi.test.test_cxf_spring.interceptors.WSSIDynamicCallBack;

public final  class Client {

	private Client() {
	}

	public static void main(String args[]) throws Exception {

		//		boolean proxy = true;
		//		if(proxy) {
		//			System.setProperty("http.proxyHost", "fr-proxy.groupinfra.com");
		//			System.setProperty("http.proxyPort", "3128");
		//		} else {
		//			System.setProperty("http.proxyHost", null);
		//		}

		//System.setProperty("nonProxyHosts", "10.82.89.12|localhost");

		/**
		 * TO RUN TCPMON tester => client => 8889 => server 8080 (cf. client-beans.xml)
		 * C:\apps>java -cp ./tcpmon-1.1.jar com.codegoogle.tcpmon.MainWindow
		 */

		// START SNIPPET: client
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});

		//HelloService
		HelloService clientHello = (HelloService)context.getBean("helloClient");

		HelloBDT hBDT = new HelloBDT();
		List<String> texts = new ArrayList<String>();
		texts.add("text1");
		texts.add("text2");
		hBDT.setName("DaKESS");
		hBDT.setTexts(texts);


		//Test Custom Headers
		List<Header> headers = new ArrayList<Header>();
		Header dummyHeader = new Header(new QName("uri:org.apache.cxf", "dummy"), "decapitated", new JAXBDataBinding(String.class));
		headers.add(dummyHeader);

		//client side:
		((BindingProvider)clientHello).getRequestContext().put(Header.HEADER_LIST, headers);
		// -------------------

		//Test logging OU cf. cxf.xml trouvé tt seul par cxf
//		org.apache.cxf.endpoint.Client client = ClientProxy.getClient(clientHello);
//		client.getInInterceptors().add(new LoggingInInterceptor());
//		client.getOutInterceptors().add(new LoggingOutInterceptor()); 
		// -----------
		
		//test thread local user/password
		WSSIDynamicCallBack.setThreadIdentity(Thread.currentThread().getName()+"user", Thread.currentThread().getName()+"passw");
		
		try {
			String response = clientHello.sayHi(hBDT);
			System.out.println("ResponseHello: " + response);
		} catch (SOAPFaultException e) {
			System.err.println("SOAPFaultException in Client => " + e.getFault().getFaultCode() + " - " + e.getFault().getFaultString() );
		}

		
		System.exit(0);
		
		//ByeService
		ByeService clientBye = (ByeService)context.getBean("byeClient");

		ByeBDT bBDT = new ByeBDT();
		List<String> texts2 = new ArrayList<String>();
		texts2.add("text1_2");
		texts2.add("text2_2");
		bBDT.setName("DaKESS Bye");
		bBDT.setTexts(texts2);

		ByeBDT bBDTresponse = null;
		try {
			bBDTresponse = clientBye.sayBye(bBDT);
			System.out.println("ResponseBye: " + bBDTresponse.getName() + " / " + bBDTresponse.getTexts());
		} catch (ByeException e) {
			System.out.println("ERROR : " + e.getMessage());
		}

		System.exit(0);
		// END SNIPPET: client
	}
}
