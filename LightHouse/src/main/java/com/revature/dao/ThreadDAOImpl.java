package com.revature.dao;

import static com.revature.util.LoggerUtil.info;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.util.SessionFactoryUtil;
import com.revature.pojo.ForumThread;
import com.revature.pojo.User;
import com.revature.util.LoggerUtil.*;

/**
 * This class implements CRUD methods for ForumThread objects
 * ForumThread will be referred to as simply thread
 * 
 * @author Robert Li
 *
 */
@Component
public class ThreadDAOImpl implements ThreadDAO {

	/**
	 * SessionFactory that creates sessions
	 */
	private static SessionFactory sf;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
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
	 * Retrieves all threads a user has created
	 * 
	 * @param user
	 * @return list of threads
	 */
	@Override
	public List<ForumThread> getThreadsByUser(User user){
		info("Getting thread by user: " + user.getUsername());
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(ForumThread.class).add(Restrictions.eq("userID", user));
		List<ForumThread> threadList = crit.list();
		tx.commit();
		sess.close();
		
		return threadList;
	}
	
	/**
	 * Retrieves a thread from the database based on title
	 * @param title
	 * @return Thread
	 */
	public ForumThread getThreadByTitle(String title) {
		info("Getting thread with title: " + title);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(ForumThread.class).add(Restrictions.eq("title", title));
		ForumThread thread = (ForumThread) crit.uniqueResult();
		
		if (thread != null) {
			info("Got thread with title:" + thread.getTitle());
		}
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
		Criteria crit = sess.createCriteria(ForumThread.class);
		List<ForumThread> threadList = crit.list();
		tx.commit();
		sess.close();
		return threadList;
	}
	
	/**
	 * Retrieves all threads from database based on the subforum the thread belongs to
	 * 
	 * @return threadList is the list of threads
	 */
	@Override
	public List<ForumThread> getAllThreadsBySubForum(String subforum){
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(ForumThread.class).add(Restrictions.eq("subforum", subforum));
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
