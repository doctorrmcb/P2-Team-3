package com.revature.driver;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojo.User;

public class Driver {
	private static UserDAO userDAO = new UserDAOImpl();
	public static void main(String[] args) {
		User user = userDAO.getUserByUsername("testUsername");
		
		System.out.println(user);
		
		User user2 = new User();
		user2.setUserID(2);
		user2.setUsername("test");
		user2.setPassword("test");
		user2.setEmailName("test");
		user2.setRoles("associate");
		user2.setFullName("test");
		user2.setBatchID("test");
		
		userDAO.createUser(user2);
	}
}
