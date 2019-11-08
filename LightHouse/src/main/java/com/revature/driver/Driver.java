package com.revature.driver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.revature.dao.QuestionDAOImpl;
import com.revature.dao.ThreadDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.util.SessionFactoryUtil;
import com.revature.pojo.ForumThread;
import com.revature.pojo.Question;
import com.revature.pojo.User;

public class Driver {
	
	private static ThreadDAOImpl tDAO = new ThreadDAOImpl();
	private static QuestionDAOImpl qDAO = new QuestionDAOImpl();
	private static UserDAOImpl uDAO = new UserDAOImpl();
	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	public static void main(String[] args) {
		tDAO.setSessionFactory(sf);
		qDAO.setSessionFactory(sf);
		uDAO.setSf(sf);
		User user = uDAO.getUserByID(1);
		List<Question> qList = new ArrayList();
		for (Question q: qList) {
			ForumThread thread = new ForumThread();
			
			thread.setPostedBy(user);
			thread.setTitle(q.getQuestionName());
			thread.setContents("Thread for discussing question " + q.getQuestionID() +": " + q.getQuestionName() );
			LocalDate localDate = LocalDate.now();
			LocalTime localTime = LocalTime.now();
			thread.setPostDate(localDate);
			thread.setPostTime(localTime);
			thread.setTopic("Quiz Question");
			thread.setSubforum("Discuss questions from the quizzes");
			thread.setLastPost(LocalDateTime.of(localDate, localTime));
			
			tDAO.createThread(thread);
		}
	}			
}
