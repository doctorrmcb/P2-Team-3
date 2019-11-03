package com.revature.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.ForumThread;
import com.revature.pojo.User;
import com.revature.service.ThreadServiceImpl;

/**
 * This controller will control everything to do with threads
 * @author Robert Li
 *
 */

@RestController
@CrossOrigin("*")
public class ForumController {
	
	private ThreadServiceImpl threadService;

	@Autowired
	public void setThreadService(ThreadServiceImpl threadService) {
		this.threadService = threadService;
	}
	
	
	/**
	 * Retrieves all threads in a subforum
	 * @param subforum
	 * @return
	 */
	@GetMapping("/forum/(subforum)")
	public List<ForumThread> getForumThreads(@PathVariable String subforum){
		return threadService.getAllThreadsBySubForum(subforum);
	}
	
	/**
	 * Creates a thread in the database
	 * @param subforum   the subforum the thread will be created in
	 * @param thread     the thread to be created, pulled from website
	 * @param sess       current httpsession
	 * @return response  Response used to dictate logic flow in angular
	 */
	@PostMapping("/forum/(subforum)")
	public ControllerResponse createThread(@PathVariable String subforum, ForumThread thread, HttpSession sess) {
		
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		
		User user = (User) sess.getAttribute("user");
		LocalDate postDate = LocalDate.now();
		LocalTime postTime = LocalTime.now();
		LocalDateTime lastPost = LocalDateTime.of(postDate, postTime);
		thread.setThreadID(-1);
		thread.setPostedBy(user);
		thread.setPostDate(postDate);
		thread.setPostTime(postTime);
		thread.setLastPost(lastPost);
		threadService.createThread(thread);
		
		response = "success";
		cr.setResponse(response);
		return cr;
	}

}
