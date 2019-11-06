package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ControllerResponse;
import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;
import static com.revature.util.LoggerUtil.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	private UserServiceImpl userService;

	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	/*
	@GetMapping("/login")
	public String loginGet(HttpSession sess, ModelMap modelMap) {
		
		if (sess.getAttribute("user") != null) {
			modelMap.addAttribute("user", sess.getAttribute("user"));
			return "home";
		}
		
		return "login";
	}
	*/
	@PostMapping("/login")
	public ControllerResponse loginPost(@RequestBody User user, ModelMap modelMap, HttpSession sess) {
		info(user + "");
		info(org.hibernate.Version.getVersionString());
		String response = "";
		ControllerResponse cr = new ControllerResponse();
		
		User checkUser = userService.getUserByUsername(user.getUsername());
		if (checkUser == null) {
			response = "Incorrect username";
			cr.setResponse(response);
			return cr;
		}
		
		User authUser = userService.loginUser(user.getUsername(), user.getPassword());
		
		if (authUser != null) {
			sess.setAttribute("user", authUser);
			modelMap.addAttribute("user", authUser);
			response = "success";
			cr.setResponse(response);
			return cr;
		} else {
			response = "Incorrect password";
			cr.setResponse(response);
			return cr;
		}
		
		
	}
	
}
