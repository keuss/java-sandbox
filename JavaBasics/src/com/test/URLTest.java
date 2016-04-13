package com.test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public URLTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			//Pas de résolution ;-)
			URL url = new URL("http://fr-wst-vm-0818.groupinfra.com:9080/BPC_TGV_CDM_INT_WAR/mule/ged/servicesdocuments?wsdl");
			long elapsedTime = System.currentTimeMillis() - start;
			System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
			
			//URL fichier
			URL urlFile = new URL("file:///C:/devs/workspace/workspace_test_2014/JavaBasics/monwsdl.wsdl");
			System.out.println(urlFile.getFile());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
