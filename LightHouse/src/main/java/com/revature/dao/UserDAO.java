package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

/**
 * Interface for UserDAOImpl
 * Ensures that all CRUD methods will be implemented
 * 
 * @author Robert Li
 */
public interface UserDAO {

	
	/**
	 * Retrieves a User from the database based on ID
	 * 
	 * @param UserID
	 * @return User
	 */
	public User getUserByID(int userID);
	
	/**
	 * Retrieves a User from the database based on username
	 * @param username
	 * @return User
	 */
	public User getUserByUsername(String username);

	
	
	/**
	 * Gets all Users from the database
	 * 
	 * @return List of all Users
	 */
	public List<User> getAllUsers();

	
	/**
	 * Creates a User in the database
	 * 
	 * @param User
	 */
	public void createUser(User user);

	/**
	 * Updates a User in the database
	 * 
	 * @param User
	 */
	public void updateUser(User user);

	/**
	 * Deletes a User in the databasea
	 * 
	 * @param User
	 */
	public void deleteUser(User user);
}
