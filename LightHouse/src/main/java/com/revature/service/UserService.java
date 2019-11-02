package com.revature.service;

import java.util.List;

import com.revature.pojo.User;

/**
 * Interface for the user service
 * user service will be the liaison between DAOs and servlet
 * user service will also validate log in
 * @author Robert Li
 *
 */
public interface UserService {

	/**
	 * Logs in user by verifying that the user is in the database
	 * 
	 * @param username user's username
	 * @param password user's password
	 * @return User if login is successful, null if not successful
	 */
	public User loginUser(String username, String password);
	
	/**
	 * retrieves a user from the database based on username
	 * @param username
	 * @return user
	 */
	public User getUserByUsername(String username);
	
	/**
	 * retrieves user from the database based on userID
	 * @param userID
	 * @return user
	 */
	public User getUserByID(int userID);
	
	/**
	 * inserts a user into the database
	 * @param user
	 */
	public void makeUser(User user);
	
	/**
	 * gets a list of all users
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * updates user
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * deletes user
	 * @param user
	 */
	public void deleteUser(User user);
	
}
