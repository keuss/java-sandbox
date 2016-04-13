package com.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represent a login form.<br>
 * It's available in Spring/JSF Context with bean id : loginBean
 */
@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean{
	
	
	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginBean.class);
	
	
	@PostConstruct
	public void init() {
		LOGGER.info("init LoginBean ...");
	}
	
	
	
	public LoginBean() {
		LOGGER.info("new LoginBean ...");
	}



	/**
	 * set in login.xhtml page
	 */
	private String login;
	
	/**
	 * set in login.xhtml page
	 */
	private String password;
	
	/**
	 * @return the login
	 */
	public String getLogin(){
		LOGGER.debug("getLogin:{}",this.login);
		return this.login;
	}
	
	/**
	 * @param login the login to set
	 */
	public void setLogin( String login ){
		LOGGER.debug("setLogin:{}",login);
		this.login = login;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword(){
		LOGGER.debug("getPassword:{}",this.password);
		return this.password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword( String password ){
		LOGGER.debug("setPassword:{}",password);
		this.password = password;
	}
}