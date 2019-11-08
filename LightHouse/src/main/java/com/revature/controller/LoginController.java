package com.revature.controller;

import static com.revature.util.LoggerUtil.info;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true" /*"*"*/)
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
	
	@GetMapping("/logout")
	public void logout(HttpSession sess) {
		sess.invalidate();
	}
	/*
	 * @RequestMapping(path = "/login", method = RequestMethod.OPTIONS) public void
	 * loginPreFlight(HttpResponse httpResponse) {
	 * httpResponse.addHeader("Access-Control-Allow-Credentials", "true"); }
	 */
	@PostMapping("/login")
	public ControllerResponse loginPost(@RequestBody User user, ModelMap modelMap, HttpSession sess) {
		info(user + "");
		info(org.hibernate.Version.getVersionString());
		String response = "";
		ControllerResponse cr = new ControllerResponse();
		//httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
		
		User checkUser = userService.getUserByUsername(user.getUsername());
		if (checkUser == null) {
			response = "Incorrect username";
			cr.setResponse(response);
			return cr;
		}
		
		User authUser = userService.loginUser(user.getUsername(), user.getPassword());
		
		if (authUser != null) {
			sess.setAttribute("user", authUser);
			info("Inside HttpSession of logincontroller" + sess.getAttribute("user"));
			modelMap.addAttribute("user", authUser);
			info("Inside modelMap of logincontroller" + modelMap.get("user"));
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
