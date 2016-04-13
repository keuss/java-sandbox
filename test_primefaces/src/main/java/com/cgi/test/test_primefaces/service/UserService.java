package com.cgi.test.test_primefaces.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.test.test_primefaces.dao.IUserDAO;
import com.cgi.test.test_primefaces.model.User;

/**
 *
 * User Service
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
public class UserService implements IUserService, InitializingBean {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	// UserDAO is injected...
	IUserDAO userDAO;
	
	// test to remove
	//FIXME
	String testOtherEnvProp;

	/**
	 * Add User
	 *
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Delete User
	 *
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}

	/**
	 * Update User
	 *
	 * @param  User user
	 */
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	/**
	 * Get User
	 *
	 * @param  int User Id
	 */
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 *
	 */
	public List<User> getUsers() {
		//TODO
		//ICI éventuellment mapping Entity <-> Model utilisé coté pres
		//car la on retourne directement l'entity JPA qui sera affiché côté html ... bof
		return getUserDAO().getUsers();
	}

	/**
	 * Get User DAO
	 *
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 *
	 * @param IUserDAO - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.info("afterPropertiesSet : [{}]", this.toString());
		
	}

	
	@Override
	public String toString() {
		return "UserService [testOtherEnvProp=" + testOtherEnvProp + "]";
	}

	public void setTestOtherEnvProp(String testOtherEnvProp) {
		this.testOtherEnvProp = testOtherEnvProp;
	}

	
}