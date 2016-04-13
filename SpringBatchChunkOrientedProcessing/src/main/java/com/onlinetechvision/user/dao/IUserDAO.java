package com.onlinetechvision.user.dao;

import java.util.List;

import com.onlinetechvision.user.User;
 
/**
 * User DAO Interface
 *
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
public interface IUserDAO {
 
    /**
     * Adds User
     *
     * @param User the user to add
     */
    void addUser(User user);
 
    /**
     * Gets User List
     * 
     * @return the list of users
     */
    List<User> getUsers();
    
    /**
     * Update user 
     * 
     * @param user to update
     */
    void updatedUser(User user);
    
    
    /**
     * Get A user to migrate
     *  
     * @param start index for read
     * @return a User to migrate or null is no user to migrate
     */
    User getToMigrateUser(int start);
    
    /**
     * Get users by name
     * 
     * @param name the user's name
     * @return the User list
     */
    List<User> getUsersByName(String name);
}
