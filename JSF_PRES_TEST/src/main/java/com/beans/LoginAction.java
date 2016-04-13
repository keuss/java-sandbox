package com.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="loginAction")
@RequestScoped
public class LoginAction{
	
	private String currentLogin="";
	
	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
	
	
	@PostConstruct
	public void init() {
		LOGGER.info("init LoginAction ...");
	}
	
	
	public LoginAction() {
		LOGGER.info("new LoginAction ...");
	}


	/**
	 * Login action
	 * @return
	 */
	public String login() {
		LOGGER.debug("Call for LoginAction.login() with [{}]", currentLogin);
        return null;
	}


	/**
	 * @param currentLogin the currentLogin to set
	 */
	public void setCurrentLogin(String currentLogin) {
		LOGGER.debug("setCurrentLogin:{}",currentLogin);
		this.currentLogin = currentLogin;
	}
	
	
	
}
