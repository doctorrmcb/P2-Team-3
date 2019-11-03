package com.revature.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.ThreadDAO;
import com.revature.pojo.ForumThread;

/**
 * Implementation of ThreadService
 * Acts as the liaison between DAOs and servlet
 * All ForumThread objects will be referred to as thread
 * @author Robert Li
 *
 */
@Component
public class ThreadServiceImpl implements ThreadService {
	
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
	 * Retrieves all threads from database based on the subforum the thread belongs to
	 * 
	 * @return threadList is the list of threads
	 */
	@Override
	public List<ForumThread> getAllThreadsBySubForum(String subforum){
		return threadDAO.getAllThreadsBySubForum(subforum);
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
