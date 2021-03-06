package com.revature.dao;

import java.util.List;

import com.revature.pojo.ForumThread;
import com.revature.pojo.User;

/**
 * This is the interface for the ThreadDAOImpl Class
 * Ensures that all CRUD methods will be implemented
 * 
 * thread referes to a ForumThread object
 * @author Robert Li
 *
 */

public interface ThreadDAO {
	
	/**
	 * Retrieves a thread from the database based on the ID
	 * 
	 * @param threadID
	 * @return ForumThread
	 */
	public ForumThread getThread(int threadID);
	
	/**
	 * Retrieves a thread from the database based on title
	 * @param title
	 * @return Thread
	 */
	public ForumThread getThreadByTitle(String title);
	
	/**
	 * Retrieves all threads from the database
	 * 
	 * @return List<ForumThread>
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
	 * Inserts new thread into database
	 * @param thread
	 */
	public void createThread(ForumThread thread);
	
	/**
	 * Updates a thread in the database
	 * @param thread
	 */
	public void updateThread(ForumThread thread);
	
	
	/**
	 * Deletes a thread from the database
	 * @param thread
	 */
	public void deleteThread(ForumThread thread);
}
