package com.onlinetechvision.user.service;

import java.util.List;

import com.onlinetechvision.user.User;
 
/**
 *
 * User Service Interface
 *
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
public interface IUserService {
 
    /**
     * Adds User
     *
     * @param User the user to add
     */
    void addUser(User user);
    
    /**
     * Update user 
     * 
     * @param user to update
     */
    void updatedUser(User user);
 
    /**
     * Gets User List
     *
     * @return List - User list
     */
    List<User> getUsers();
    
    /**
     * Get A user to migrate
     *  
     * @param start index for read
     * @return a User to migrate or null is no user to migrate
     */
    User getToMigrateUser(int start);
}