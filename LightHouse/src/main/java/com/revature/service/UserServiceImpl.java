package com.revature.service;

import static com.revature.util.LoggerUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;

/**
 * Implementation of User Service
 * User service will serve as the liaison between DAOs and servlet
 * User service also validates log in
 * @author Robert Li
 *
 */
public class UserServiceImpl implements UserService {

	/**
	 * The DAO that interacts with the database
	 */
	private static UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	/**
	 * Logs in user by verifying that the user is in the database
	 * 
	 * @param username user's username
	 * @param password user's password
	 * @return User if login is successful, null if not successful
	 */
	public User loginUser(String username, String password) {
		debug("Attempted login with creds: Username: " + username + " Password: " + password);

		User user = userDAO.getUserByUsername(username);
		if (user == null) {
			return null;
		}

		info("User: " + user);

		if (((user.getUsername() != null) && (user.getPassword() != null)) && (user.getPassword().equals(password))) {
			debug("Checking if Username: " + user.getUsername() + " Password: " + user.getPassword());
			return user;

		}
		debug("Checking if Username: " + user.getUsername() + " Password: " + user.getPassword());
		return null;
	}
	
	
	/**
	 * retrieves a user from the database based on username
	 * @param username
	 * @return user
	 */
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}
	
	/**
	 * retrieves user from the database based on userID
	 * @param userID
	 * @return user
	 */
	public User getUserByID(int userID) {
		return userDAO.getUserByID(userID);
	}
	
	/**
	 * inserts a user into the database
	 * @param user
	 */
	public void makeUser(User user) {
		userDAO.createUser(user);
	}
	
	/**
	 * gets a list of all users
	 * @return
	 */
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	
	/**
	 * updates user
	 * @param user
	 */
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	/**
	 * deletes user
	 * @param user
	 */
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

}
