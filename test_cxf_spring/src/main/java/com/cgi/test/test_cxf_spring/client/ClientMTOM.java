package com.cgi.test.test_cxf_spring.client;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.commons.io.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgi.test.test_cxf_spring.mtom.bdt.DataBDT;
import com.cgi.test.test_cxf_spring.mtom.itf.ByteArrayDataSource;
import com.cgi.test.test_cxf_spring.mtom.itf.MTOMService;

public class ClientMTOM {


	private ClientMTOM() {
	}

	public static void main(String args[]) throws Exception {

		// START SNIPPET: client
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});

		//mtomClient
		MTOMService mtomClient = (MTOMService)context.getBean("mtomClient");

		System.out.println("starting  ClientMTOM test 1 ...");
		File myXmlFile  = new File("d:/workspace_test_2012/test_cxf_spring/file.xml");
		System.out.println("myXmlFile : " + myXmlFile.getAbsolutePath());

		DataSource source = new FileDataSource(myXmlFile);
		DataHandler handler = new DataHandler(source);
		DataBDT file = new DataBDT(handler, "xml");
		
		String response = mtomClient.sendData(file);
		System.err.println("response from WS : [" + response + "]");
		
		// other test with wrapper
		System.out.println("starting  ClientMTOM test 2 ...");
		byte[] data = FileUtils.readFileToByteArray(new File("d:/workspace_test_2012/test_cxf_spring/file.bmp"));
		DataHandler dh = new DataHandler(new ByteArrayDataSource(data));
		DataBDT file2 = new DataBDT(dh, "bmp");
		String response2 = mtomClient.sendData(file2);
		System.err.println("response from WS : [" + response2 + "]");

		System.exit(0);
		// END SNIPPET: client
	}

}
