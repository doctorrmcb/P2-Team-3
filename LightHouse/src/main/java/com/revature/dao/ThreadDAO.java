package com.revature.dao;

import java.util.List;

import com.revature.pojo.ForumThread;

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
	 * Retrieves all threads from the database
	 * 
	 * @return List<ForumThread>
	 */
	
	public List<ForumThread> getAllThreads();
	
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
