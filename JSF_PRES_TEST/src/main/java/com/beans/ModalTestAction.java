package com.beans;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ManagedBean(name="modalTestAction")
@SessionScoped
public class ModalTestAction {


	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ModalTestAction.class);
	
	private String myParamTest = "CLOSED"; 
	private String otherParamTest = "";
	
	/**
	 * @param event
	 */
	public void myAction(ActionEvent event) {
		LOGGER.info("Call for myAction ...");
		
		//TEST f:param
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String paramtest1 = requestMap.get("param1").toString();
		LOGGER.info("paramtest1 : [{}]", paramtest1);
		this.myParamTest = paramtest1;
		
		//TEST f:attribute
		String paramtest2 = (String)event.getComponent().getAttributes().get("param2");
		LOGGER.info("paramtest2 : [{}]", paramtest2);
	}
	
	/**
	 * @param event
	 */
	public void myAction2(ActionEvent event) {
		LOGGER.info("Call for myAction2 ...");
	}
	

	/**
	 * @return the myParamTest
	 */
	public String getMyParamTest() {
		LOGGER.info("Call for getMyParamTest ...");
		return myParamTest;
	}

	/**
	 * @param myParamTest the myParamTest to set
	 */
	public void setMyParamTest(String myParamTest) {
		LOGGER.info("Call for setMyParamTest with [{}]", myParamTest);
		this.myParamTest = myParamTest;
	}

	/**
	 * @return the otherParamTest
	 */
	public String getOtherParamTest() {
		LOGGER.info("Call for getOtherParamTest ...");
		return otherParamTest;
	}

	/**
	 * @param otherParamTest the otherParamTest to set
	 */
	public void setOtherParamTest(String otherParamTest) {
		LOGGER.info("Call for setOtherParamTest with [{}]", otherParamTest);
		this.otherParamTest = otherParamTest;
	}
	
	

}
