package com.onlinetechvision.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.onlinetechvision.user.User;
 
/**
 * User DAO
 *
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */ 
public class UserDAO implements IUserDAO {
 
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	
    private SessionFactory sessionFactory;
 
    /**
     * Gets Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    /**
     * Sets Hibernate Session Factory
     *
     * @param SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    /**
     * Adds User
     *
     * @param  User user
     */
    public void addUser(User user) {
        getSessionFactory().getCurrentSession().save(user);
    }
    
    
    /**
     * Update user 
     * 
     * @param user to update
     */
    public void updatedUser(User user) {
        getSessionFactory().getCurrentSession().update(user);
    }
 
    /**
     * Gets User List
     *
     * @return List - User list
     */
    @SuppressWarnings({ "unchecked" })
	public List<User> getUsers() {
        List<User> list = getSessionFactory().getCurrentSession().createQuery("from User").list();
        return list;
    }
    
    @SuppressWarnings({ "unchecked" })
    public User getToMigrateUser(int start) {
    	Query q = getSessionFactory().getCurrentSession().createQuery("from User order by id asc");
    	q.setFirstResult(start); //0,1,..
    	q.setMaxResults(1); //1
		List<User> list = q.list();
		logger.info("getToMigrateUser size [{}]", list.size());
		if(list == null || list.size() <= 0) {
			return null;
		}
    	return list.get(0);
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<User> getUsersByName(String name) {
		Query q  = getSessionFactory().getCurrentSession().getNamedQuery("users.by.name");
		q.setString("name", name);
		List<User> list = q.list();
		return list;
	}
 
}
