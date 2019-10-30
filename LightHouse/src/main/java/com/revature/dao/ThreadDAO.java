package com.revature.dao;

import java.util.List;

/*
 * Author - Robert Li
 */

public interface ThreadDAO {
	
	public Thread getThread(int threadID);
	
	public List<Thread> getAllThreads();
	
	public void createThread(Thread thread);
	
	public void updateThread(Thread thread);
	
	public void deleteThread(Thread thread);
}
