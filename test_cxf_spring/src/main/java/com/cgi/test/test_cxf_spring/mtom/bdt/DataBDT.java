package com.cgi.test.test_cxf_spring.mtom.bdt;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


@XmlType
//@XmlAccessorType(XmlAccessType.FIELD)
public class DataBDT {

	@XmlMimeType("application/octet-stream")
	private DataHandler file;

	private String name;


	public DataBDT() {
		super();
	}


	public DataBDT(DataHandler file, String name) {
		super();
		this.file = file;
		this.name = name;
	}


	/**
	 * @return the file
	 */
	public DataHandler getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
//	public void setFile(DataHandler file) {
//		// error si présent :
//		// Caused by: com.sun.xml.bind.v2.runtime.IllegalAnnotationsException: 1 counts of IllegalAnnotationExceptions
//		// Class has two properties of the same name "file"
//		// ok si @XmlAccessorType(XmlAccessType.FIELD) si la classe
//		this.file = file;
//	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



}
