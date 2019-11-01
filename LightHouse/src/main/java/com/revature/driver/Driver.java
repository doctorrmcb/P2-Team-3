package com.revature.driver;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojo.User;

public class Driver {
	private static UserDAO userDAO = new UserDAOImpl();
	public static void main(String[] args) {
		User user = userDAO.getUserByUsername("testUsername");
		
		System.out.println(user);
	}
}
