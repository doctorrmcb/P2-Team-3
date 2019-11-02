package com.revature.service;

import java.util.List;

import com.revature.pojo.ForumThread;

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
	 * Gets all threads from the database
	 * 
	 * @return List of all threads
	 */
	public List<ForumThread> getAllThreads();

	
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
