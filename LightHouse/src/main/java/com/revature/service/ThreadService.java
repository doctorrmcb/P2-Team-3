package com.revature.service;

import java.util.List;

import com.revature.pojo.ForumThread;
import com.revature.pojo.User;

/**
 * Interface for the ThreadService object
 * Will act as the liaison between DAOs and servlet
 * All ForumThread objects will be referred to as thread
 * @author Robert Li
 *
 */
public interface ThreadService {
	
	/**
	 * Retrieves a thread from the database based on ID
	 * 
	 * @param threadID
	 * @return Thread
	 */
	public ForumThread getThread(int threadID);
	
	/**
	 * Retrieves a thread from the database based on title
	 * @param title
	 * @return Thread
	 */
	public ForumThread getThreadByTitle(String title);

	
	/**
	 * Gets all threads from the database
	 * 
	 * @return List of all threads
	 */
	public List<ForumThread> getAllThreads();
	

	/**
	 * Retrieves all threads a user has created
	 * 
	 * @param user
	 * @return list of threads
	 */
	public List<ForumThread> getThreadsByUser(User user);
	
	
	/**
	 * Retrieves all threads based on subforum
	 * 
	 * @return List<ForumThread> is a list of threads from that specific subforum
	 */
	public List<ForumThread> getAllThreadsBySubForum(String subforum);

	
	/**
	 * Creates a thread in the database
	 * 
	 * @param thread
	 */
	public void createThread(ForumThread thread);

	/**
	 * Updates a thread in the database
	 * 
	 * @param thread
	 */
	public void updateThread(ForumThread thread);

	/**
	 * Deletes a thread in the database
	 * 
	 * @param thread
	 */
	public void deleteThread(ForumThread thread);

}
