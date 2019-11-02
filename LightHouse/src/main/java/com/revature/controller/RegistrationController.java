package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
public class RegistrationController {
	
	private UserServiceImpl userService;

	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user, HttpSession sess) {
		
		if (user != null) {
			user.setRoles("Associate");
			userService.makeUser(user);
			sess.setAttribute("user", user);
			return user;
		}
		return null;
	}
}

