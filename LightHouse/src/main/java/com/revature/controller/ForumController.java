package com.revature.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.ForumThread;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.service.PostServiceImpl;
import com.revature.service.ThreadServiceImpl;
import static com.revature.util.LoggerUtil.*;

/**
 * This controller will control everything to do with threads
 * @author Robert Li
 *
 */

@RestController
@CrossOrigin(origins = /*"localhost:4200"*/ "*")
public class ForumController {
	
	private ThreadServiceImpl threadService;
	private PostServiceImpl postService;

	@Autowired
	public void setThreadService(ThreadServiceImpl threadService) {
		this.threadService = threadService;
	}
	
	@Autowired
	public void setPostService(PostServiceImpl postService) {
		this.postService = postService;
	}



	/**
	 * Retrieves all threads in a subforum
	 * @param subforum
	 * @return
	 */
	@GetMapping("/forum/{subforum}")
	public List<ForumThread> getForumThreads(@PathVariable String subforum){
		info("Reached getForumThreads");
		List<ForumThread> threadList = threadService.getAllThreads(); //getAllThreadsBySubForum(subforum);
		info("ThreadList: " + threadList);
		return threadService.getAllThreadsBySubForum(subforum);
	}
	
	/**
	 * Creates a thread in the database
	 * @param subforum   the subforum the thread will be created in
	 * @param thread     the thread to be created, pulled from website
	 * @param sess       current httpsession
	 * @return response  Response used to dictate logic flow in angular
	 */
	@PostMapping("/forum/{subforum}")
	public ControllerResponse createThread(@PathVariable String subforum, @RequestBody ForumThread thread, HttpSession sess) {
		
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		info("Creating thread with title: " + thread.getTitle());
		if (threadService.getThreadByTitle(thread.getTitle()) != null) {
			response = "A thread with this title already exists";
			cr.setResponse(response);
			return cr;
		}
		User user = (User) sess.getAttribute("user");
		info("Inside session of forum " + sess.getAttribute("user"));
		LocalDate postDate = LocalDate.now();
		LocalTime postTime = LocalTime.now();
		LocalDateTime lastPost = LocalDateTime.of(postDate, postTime);
		thread.setThreadID(-1);
		thread.setPostedBy(user);
		thread.setPostDate(postDate);
		thread.setPostTime(postTime);
		thread.setLastPost(lastPost);
		thread.setTopic(subforum);
		thread.setSubforum(subforum);
		threadService.createThread(thread);
		
		response = "success";
		cr.setResponse(response);
		return cr;
	}

	/**
	 * Retrieves all posts in a thread based on thread title
	 * @param title
	 * @return list of posts
	 */
	@GetMapping("/post/{title}")
	public List<Post> getPostsByTitle(@PathVariable String title){
		info("Reached getPostsByTitle of forum controller");
		ForumThread thread = threadService.getThreadByTitle(title);
		List<Post> postList = postService.getPostsByThread(thread);
		info("PostList: " + postList);
		return postList;
	}
	
	
	@PostMapping("/{title}/post")
	public ControllerResponse createPost(@PathVariable String title, @RequestBody Post post, HttpSession sess) {
		
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		
		User user = (User) sess.getAttribute("user");
		info("Inside session of post " + sess.getAttribute("user"));
		LocalDate postDate = LocalDate.now();
		LocalTime postTime = LocalTime.now();
		LocalDateTime lastPost = LocalDateTime.of(postDate, postTime);
		post.setPostID(-1);
		ForumThread thread = threadService.getThreadByTitle(title);
		thread.setLastPost(lastPost);
		threadService.updateThread(thread);
		info(thread.toString());
		post.setThreadID(thread);
		post.setPosted_by(user);
		post.setPostDate(postDate);
		post.setPostTime(postTime);
		post.setContents(post.getContents());
		postService.createPost(post);
		
		response = "success";
		cr.setResponse(response);
		return cr;
	}
}
