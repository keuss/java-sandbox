package com.cgi.test.test_cxf_spring.mtom.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.cgi.test.test_cxf_spring.mtom.bdt.DataBDT;
import com.cgi.test.test_cxf_spring.mtom.itf.MTOMService;

@Service("mtomservices")
public class MTOMServiceImpl implements MTOMService {

	public String sendData(DataBDT dataBDT) {

		System.out.println("Call MTOMServiceImpl.sendData at " + new Date() + ", with : dataBDT.getName() : " + dataBDT.getName());

		DataHandler dh = dataBDT.getFile();
		String fileName = "d:/workspace_test_2012/test_cxf_spring/servtest" + "." + dataBDT.getName();
		File fServer = new File(fileName);
		FileUtils.deleteQuietly(fServer);

		try {
			toFile(toBytes(dh), fileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "OK";
	}


	/**
	 * @param handler
	 * @return the byte array
	 * @throws IOException
	 */
	private static byte[] toBytes(DataHandler handler) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		handler.writeTo(output);
		System.out.println("Done toBytes");
		return output.toByteArray();
	}



	/**
	 * @param bFile
	 */
	private static void toFile(byte[] bFile, String fileName) throws IOException {

		//convert array of bytes into file
		FileOutputStream fileOuputStream = new FileOutputStream(fileName); 
		fileOuputStream.write(bFile);
		fileOuputStream.close();

		System.out.println("Done bytesToFile");

	}

}
