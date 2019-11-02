package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.ThreadDAO;
import com.revature.pojo.ForumThread;

/**
 * Implementation of ThreadService
 * Acts as the liaison between DAOs and servlet
 * All ForumThread objects will be referred to as thread
 * @author Robert Li
 *
 */
public class ThreadServiceImpl {
	
	/**
	 * The dao that will interact with the database
	 */
	private static ThreadDAO threadDAO;
	
	@Autowired
	public void setThreadDAO(ThreadDAO threadDAO) {
		this.threadDAO = threadDAO;
	}
	
	/**
	 * Retrieves a thread from the database based on ID
	 * 
	 * @param threadID
	 * @return Thread
	 */
	public ForumThread getThread(int threadID) {
		return threadDAO.getThread(threadID);
	}

	
	
	/**
	 * Gets all threads from the database
	 * 
	 * @return List of all threads
	 */
	public List<ForumThread> getAllThreads(){
		return threadDAO.getAllThreads();
	}

	
	/**
	 * Creates a thread in the database
	 * 
	 * @param thread
	 */
	public void createThread(ForumThread thread) {
		threadDAO.createThread(thread);
	}

	/**
	 * Updates a thread in the database
	 * 
	 * @param thread
	 */
	public void updateThread(ForumThread thread){
		threadDAO.updateThread(thread);
	}

	/**
	 * Deletes a thread in the database
	 * 
	 * @param thread
	 */
	public void deleteThread(ForumThread thread) {
		threadDAO.deleteThread(thread);
	}
}
