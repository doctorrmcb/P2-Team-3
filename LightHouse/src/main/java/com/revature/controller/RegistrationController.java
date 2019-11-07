package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;


/**
 * This controller handles registration
 * @author Robert Li
 *
 */
@RestController
@CrossOrigin(origins = /*"localhost:4200"*/"*")
public class RegistrationController {
	
	/**
	 * Service for creating users
	 */
	private UserServiceImpl userService;

	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	/**
	 * This method will attempt to register a user
	 * If the username already exists, it should respond by saying that the username is already taken
	 * Above currently doesn't work
	 * 
	 * @param user is the user object sent to the controller from the web app
	 * @param sess is the http session
	 * @return User is a response used to dictate behavior in Angular
	 */
	@PostMapping("/register")
	public ControllerResponse registerUser(@RequestBody User user, HttpSession sess) {
		
		ControllerResponse cr = new ControllerResponse();
		
		String response = "";
		
		User checkUser = userService.getUserByUsername(user.getUsername());
		
		if (checkUser != null) {
			response = "Username already taken";
			cr.setResponse(response);
			return cr;
		}
		
		if (user != null) {
			user.setRoles("Associate");
			user.setBatchID("Pending");
			userService.makeUser(user);
			sess.setAttribute("user", user);
			response = "registered";
			cr.setResponse(response);
			return cr;
		}
		
		//TODO: Add check to see if user already exists.
		return null;
	}
}

