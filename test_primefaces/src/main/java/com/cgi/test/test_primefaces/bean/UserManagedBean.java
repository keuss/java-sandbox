package com.cgi.test.test_primefaces.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.cgi.test.test_primefaces.model.User;
import com.cgi.test.test_primefaces.service.IUserService;
import com.cgi.test.test_primefaces.utils.FacesAccessor;

/**
 *
 * User Managed Bean
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@ManagedBean(name="userMB")
@ViewScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagedBean.class);

	//Spring User Service is injected...
	@ManagedProperty(value="#{UserService}")
	IUserService userService;

	List<User> userList;

	private int id = 0;
	private String name = "";
	private String surname = "";
	private boolean addOK = false;
	
	/**
	 * 
	 */
	public void myValidator() {  
		// with <p:ajax event="blur" update="nameMsg" listener="#{userMB.myValidator}" immediate="false" />
    	LOGGER.debug("Call for UserManagedBean.myValidator at : " + new Date() );
    	LOGGER.debug("name : [" + name + "]");
    	FacesContext context = FacesContext.getCurrentInstance();
    	
    	if(null != name &&  !name.isEmpty() && name.length() < 5) {
    		context.addMessage("userFrom:name", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sever message", "Taille de 5 min pour name !"));
    	}
    	if(null == name || name.isEmpty()) {
    		//idForm:for
    		context.addMessage("userFrom:name", new FacesMessage(FacesMessage.SEVERITY_WARN, "Sever warn", "replir name"));
    	}
    } 
	
	/**
	 * 
	 */
	public void myValidator500() {  
		// with <p:ajax event="blur" update="nameMsg" listener="#{userMB.myValidator500}" immediate="false" onerror="errorCallback('userFrom:name')" />
    	LOGGER.debug("Call for UserManagedBean.myValidator500 at : " + new Date() );
    	LOGGER.debug("name : [" + name + "]");
    	FacesContext context = FacesContext.getCurrentInstance();
    	
    	if(null != name &&  !name.isEmpty() && name.length() < 5) {
    		context.addMessage("userFrom:name", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sever message", "Taille de 5 min pour name !"));
    		context.getExternalContext().setResponseStatus(500);
    	}
    	if(null == name || name.isEmpty()) {
    		//idForm:for
    		context.addMessage("userFrom:name", new FacesMessage(FacesMessage.SEVERITY_WARN, "Sever warn", "replir name"));
    		context.getExternalContext().setResponseStatus(500);
    	}
    	// fact that you are throwing exception got nothing to do with ajax failure ! see :
    	// http://stackoverflow.com/questions/11661051/primefaces-with-jsf-onerror-in-the-pcommandbutton-doesnt-work
    	// http://forum.primefaces.org/viewtopic.php?f=3&t=19296
    	// try with error HTTP context.getExternalContext().setResponseStatus(500); => erreur ajax (onerror callback) ok, mais unable to get message in client side !
    } 
	
	/**
	 * 
	 */
	public void myValidatorSucces() {
		
		// with <p:ajax event="blur" update="nameMsg" listener="#{userMB.myValidatorSucces}" immediate="false" oncomplete="handleNameValidate(xhr, status, args)" />
    	LOGGER.debug("Call for UserManagedBean.myValidatorSucces at : " + new Date() );
    	LOGGER.debug("name : [" + name + "]");
    	LOGGER.debug("id : [" + id + "]");
    	LOGGER.debug("surname : [" + surname + "]");
    	
    	FacesContext fcontext = FacesContext.getCurrentInstance();
    	RequestContext rcontext = RequestContext.getCurrentInstance();  
    	FacesMessage msgName = null; 
    	FacesMessage msgId = null; 
    	boolean nameValid = true;
    	boolean idValid = true;
    	
    	// setter seams slow, this method is sometimes called before setter (i.e. name = null, id = 0, ...) =>
    	// NO it's becoz' a RequestScope ManagedBean is newly instanciated after actions between the view and the ManagedBean !!!
    	// OK with @ViewScoped (not RequestScoped) !!!!!!!!!!!! but need an update from reset btn to clean field now (with ViewScoped)
    	
    	// with immediate="true" on <:pajax .../> => myValidatorSucces() called before the setter :), here need to be false, to call the setter before this method (used as a validation method)
    	// immediate : Boolean value that determines the phaseId to execute listener. Default is false meaning "Invoke Application" phase, when true phase is "Apply Request Values".
    	
    	//id #####################################################
    	if(id >= 100) {
    		idValid = false;
    		msgId = new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn message", "id ne doit pas etre supérieur à 100 !");
    	}
    	
    	//name ###################################################
    	if(null != name && name.length() < 5) {
    		nameValid = false;
    		msgName = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sever message", "Taille de 5 min pour name !");
    	}
    	
    	if(!idValid) {
    		// add error message
    		fcontext.addMessage("userFrom:id", msgId);
    		addOK = false;
    	}
    	
    	if(!nameValid) {
    		// add error message
    		fcontext.addMessage("userFrom:name", msgName);
    		addOK = false;
    	}
    	
    	if(nameValid && idValid) {
    		addOK = true;
    	}
    	
    	// see in xhtml :)
    	rcontext.addCallbackParam("nameValid", nameValid);  
    	rcontext.addCallbackParam("idValid", idValid);  
    }
	
	
	/**
	 * Add User
	 *
	 * @return String - Response Message
	 */
	public String addUser() {
		try {
			User user = new User();
			user.setId(getId());
			user.setName(getName());
			user.setSurname(getSurname());
			addDataConfiToAllUser(user);
			getUserService().addUser(user);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  

		return ERROR;
	}
	
	/**
	 * add constant data to all added users ... for exemple
	 * 
	 * @param user
	 */
	public void addDataConfiToAllUser(User user) {
		//get param bean : no need to inject this bean every where : use utils
		//Injection is good, but sometimes if beans are rare called, it’s not necessary to inject beans into each other
		InitBean initBean = (InitBean)FacesAccessor.getManagedBean("initBean");
		user.setSurname(initBean.getMapConfig().get("key1").toString());
	}

	/**
	 * Reset Fields
	 *
	 */
	public void reset() {
		LOGGER.debug("Call for reset ...");
		this.setId(0);
		this.setName("");
		this.setSurname("");
		this.addOK = false;
	}

	/**
	 * Get User List
	 *
	 * @return List - User List
	 */
	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}

	/**
	 * Get User Service
	 *
	 * @return IUserService - User Service
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Set User Service
	 *
	 * @param IUserService - User Service
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Set User List
	 *
	 * @param List - User List
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * Get User Id
	 *
	 * @return int - User Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set User Id
	 *
	 * @param int - User Id
	 */
	public void setId(int id) {
		LOGGER.debug("call setId : " + id + " at : " + new Date() );  
		this.id = id;
	}

	/**
	 * Get User Name
	 *
	 * @return String - User Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set User Name
	 *
	 * @param String - User Name
	 */
	public void setName(String name) {
		LOGGER.debug("call setName : " + name + " at : " + new Date() );  
		this.name = name;
	}

	/**
	 * Get User Surname
	 *
	 * @return String - User Surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Set User Surname
	 *
	 * @param String - User Surname
	 */
	public void setSurname(String surname) {
		LOGGER.debug("call setSurname : " + surname + " at : " + new Date() );  
		this.surname = surname;
	}

	/**
	 * @return the addOK
	 */
	public boolean isAddOK() {
		return addOK;
	}

}