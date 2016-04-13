package com.onlinetechvision.user.service;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.onlinetechvision.user.User;
import com.onlinetechvision.user.dao.IUserDAO;
 
/**
 *
 * User Service
 *
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
public class UserService implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
 
    IUserDAO userDAO;
 
    /**
	 * {@inheritDoc}
	 */
    @Transactional(readOnly = false)
    public void addUser(User user) {
    	logger.info("Call for addUser ...");
        getUserDAO().addUser(user);
    }
 
    /**
	 * {@inheritDoc}
	 */
    public List<User> getUsers() {
    	logger.info("Call for getUsers ...");
        return getUserDAO().getUsers();
    }
 
    public IUserDAO getUserDAO() {
        return userDAO;
    }
 
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
    /**
	 * {@inheritDoc}
	 */
    @Transactional(readOnly = false)
    public void updatedUser(User user) {
    	if(user != null) {
    		logger.info("Call for updatedUser with user id [{}]", user.getId());
    	}
        getUserDAO().updatedUser(user);
    }

    /**
	 * {@inheritDoc}
	 */
	public User getToMigrateUser(int start) {
		logger.info("Call for getToMigrateUser ...");
        return getUserDAO().getToMigrateUser(start);
	}
}