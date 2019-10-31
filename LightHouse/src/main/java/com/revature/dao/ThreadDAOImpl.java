package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.util.SessionFactoryUtil;
import com.revature.pojo.ForumThread;
import com.revature.util.LoggerUtil.*;

/**
 * This class implements CRUD methods for ForumThread objects
 * ForumThread will be referred to as simply thread
 * 
 * @author Robert Li
 *
 */
public class ThreadDAOImpl implements ThreadDAO {

	/**
	 * SessionFactory that creates sessions
	 */
	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	/**
	 * Retrieves a thread object from the database
	 * 
	 * @param threadID is the ID of the thread to be retrieved
	 * @return 
	 */
	@Override
	public ForumThread getThread(int threadID) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		ForumThread thread = (ForumThread) sess.get(ForumThread.class, threadID);
		tx.commit();
		sess.close();
		return thread;
	}

	
	/**
	 *Retrieves all threads from the database
	 *
	 *@return threadList is a list of all threads
	 */
	@Override
	public List<ForumThread> getAllThreads() {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Thread.class);
		List<ForumThread> threadList = crit.list();
		tx.commit();
		sess.close();
		return threadList;
	}

	/**
	 * Inserts a new thread into the database
	 * @param thread
	 */
	@Override
	public void createThread(ForumThread thread) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(thread);
		tx.commit();
		sess.close();
	}

	/**
	 * Updates a thread in the database
	 * @param thread
	 */
	
	@Override
	public void updateThread(ForumThread thread) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(thread);
		tx.commit();
		sess.close();
	}

	
	/**
	 * Deletes a thread in the database
	 * 
	 * @param thread
	 */
	@Override
	public void deleteThread(ForumThread thread) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(thread);
		tx.commit();
		sess.close();
	}

}
