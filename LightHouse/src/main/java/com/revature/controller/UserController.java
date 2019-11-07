package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ForumThread;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.service.PostServiceImpl;
import com.revature.service.ThreadServiceImpl;
import com.revature.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
public class UserController {
	
	private UserServiceImpl userService;
	private ThreadServiceImpl threadService;
	private PostServiceImpl postService;
	
	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setThreadService(ThreadServiceImpl threadService) {
		this.threadService = threadService;
	}
	
	@Autowired
	public void setPostService(PostServiceImpl postService) {
		this.postService = postService;
	}
	
	/**
	 * Gets all posts by a user
	 * 
	 * @param username of the user
	 * @return all posts the user has made
	 */
	@GetMapping("/{username}/posts")
	public List<Post> getPostsByUser(@PathVariable String username){
		User user = userService.getUserByUsername(username);
		List<Post> postList = postService.getPostsByUser(user);
		return postList;
	}
	
	/**
	 * Gets all threads by a user
	 * 
	 * @param username of the user
	 * @return all threads the user has made
	 */
	@GetMapping("/{username}/threads")
	public List<ForumThread> getThreadsByUser(@PathVariable String username){
		User user = userService.getUserByUsername(username);
		List<ForumThread> threadList = threadService.getThreadsByUser(user);
		return threadList;
	}
	
	/**
	 * Gets a user from the username
	 * 
	 * @param username of the user
	 * @return user
	 */
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		User user = userService.getUserByUsername(username);
		return user;
	}
	
	

}
