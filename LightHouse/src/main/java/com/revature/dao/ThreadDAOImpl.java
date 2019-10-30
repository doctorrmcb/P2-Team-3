package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.util.SessionFactoryUtil;
import com.revature.util.LoggerUtil.*;

/*
 * Author - Robert Li
 */
public class ThreadDAOImpl implements ThreadDAO {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@Override
	public Thread getThread(int threadID) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Thread thread = (Thread) sess.get(Thread.class, threadID);
		tx.commit();
		sess.close();
		return thread;
	}

	@Override
	public List<Thread> getAllThreads() {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Thread.class);
		List<Thread> threadList = crit.list();
		tx.commit();
		sess.close();
		return threadList;
	}

	@Override
	public void createThread(Thread thread) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(thread);
		tx.commit();
		sess.close();
	}

	@Override
	public void updateThread(Thread thread) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(thread);
		tx.commit();
		sess.close();
	}

	@Override
	public void deleteThread(Thread thread) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(thread);
		tx.commit();
		sess.close();
	}

}
