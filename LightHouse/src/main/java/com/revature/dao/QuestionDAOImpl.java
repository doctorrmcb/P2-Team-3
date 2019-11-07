package com.revature.dao;	

import static com.revature.util.LoggerUtil.*;	

import java.util.ArrayList;	
import java.util.List;	

import org.hibernate.Criteria;	
import org.hibernate.HibernateException;	
import org.hibernate.Session;	
import org.hibernate.SessionFactory;	
import org.hibernate.Transaction;	
import org.hibernate.criterion.Restrictions;	
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Component;	

import com.revature.pojo.Question;	
import com.revature.util.SessionFactoryUtil;	

/**	
 * This class implements CRUD methods for Question objects	
 * 	
 * @author Pameni Gaelle & Roberto Rodriguez	
 */	
@Component	
public class QuestionDAOImpl implements QuestionDAO {	

	SessionFactory sf = SessionFactoryUtil.getSessionFactory();	

	public void setSessionFactory(SessionFactory sf) {	
		this.sf = sf;	
	}	

	/**	
	 * Create a Question into the database based on the question object	
	 * 	
	 * @param question object	
	 * @return true if the question have been created and false otherwise	
	 **/	
	@Override	
	public boolean createQuestion(Question q) {	

		Session session = null;	
		Transaction tx = null;	

		try {	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// creating question	
			info("creating new question...");	
			session.save(q);	

			// commit transaction	
			tx.commit();	
			info("Transaction has been commited");	
			return true;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			error("creating question method failed!");	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			info("returning a null question object");	
			return false;	

		} finally {	
			// closing session	
			info("closing session...");	
			session.close();	
		}	
	}	

	/**	
	 * Read a Question from the database using the question ID	
	 * 	
	 * @param questionID	
	 * @return the question if the question was fetched and null otherwise	
	 **/	
	@Override	
	public Question getQuestion(int questionID) {	

		Session session = null;	
		Criteria criteria = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	

			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// creating criteria	
			info("creating criteria...");	
			criteria = session.createCriteria(Question.class);	
			criteria.add(Restrictions.eq("questionID", questionID));	

			q = (Question) criteria.uniqueResult();	
			// if question is not null return the question object	
			if (q != null) {	
				info("Question is found!");	
				// returning the question	
				return q;	
			}	

			// committing the transaction	
			tx.commit();	
			info("commiting the transaction...");	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			error("getQuestion method failed!");	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			info("getQuestion transaction has failed");	
			q = null;	

		} finally {	
			// closing the session	
			info("Closing the session...");	
			session.close();	
		}	
		return q;	
	}	

	/**	
	 * Read all the questions from the database	
	 * 	
	 * @return a list of questions if the list is not empty and null otherwise	
	 **/	
	@Override	
	public List<Question> getAllQuestions() {	

		Session session = null;	
		Criteria criteria = null;	
		List<Question> result = new ArrayList<Question>();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// making the criteria	
			info("Creating criteria...");	

			// creating criteria	
			criteria = session.createCriteria(Question.class);	
			result = criteria.list();	
			return result;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			// transaction has failed, so return null	
			error("getAllQuestions method failed!");	
			result = null;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
		return result;	
	}	

	/**	
	 * Read all the question from the database related to a particular category	
	 * 	
	 * @param categoryName	
	 * @return a list of questions if there are question related to that category	
	 *         and null otherwise	
	 **/	
	@Override	
	public List<Question> getAllQuestionsbyCategory(String catName) {	

		Session session = null;	
		Criteria criteria = null;	
		List<Question> result = new ArrayList<Question>();	
		CategoryDAOImpl cat = new CategoryDAOImpl();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// making the criteria	
			info("Creating criteria...");	

			// creating criteria	
			criteria = session.createCriteria(Question.class);	
			criteria.add(Restrictions.eq("cat", cat.getCat(catName)));	

			// getting the list of objects that have the same category	
			result = criteria.list();	
			info(result.toString());	
			return result;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			// getAllQuestionsbyCategory failed so return a null object question	
			error("getAllQuestionsbyCategory method failed!");	
			result = null;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
		return result;	
	}	

	/**	
	 * Update a Question content into the database based on the questionID	
	 * 	
	 * @param questionID, newName	
	 * @return true if the question have been updated and false otherwise	
	 **/	
	@Override	
	public boolean updateQuestionName(int questionID, String newName) {	

		Session session = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// getting the object Question	
			q = getQuestion(questionID);	
			info("getting the object question by id");	

			// change the question name.	
			info("updating the name of the question...");	
			q.setQuestionName(newName);	

			// saving or updating object question	
			session.saveOrUpdate(q);	

			// commit transaction	
			tx.commit();	
			info("Transaction has been commited");	
			return true;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			error("Updating method failed!");	
			return false;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
	}	

	/**	
	 * Update a Question correct answer into the database based on the questionID	
	 * 	
	 * @param questionID, UpdatedAnswer	
	 * @return true if the answer have been updated and false otherwise	
	 **/	
	@Override	
	public boolean updateCorrectAnswer(int questionID, String UpdatedAnswer) {	

		Session session = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// get the object Question	
			info("getting the object question by id");	
			q = getQuestion(questionID);	

			// change the correct answer.	
			info("updating the correct answer");	
			q.setCorrectAnswer(UpdatedAnswer);	

			// saving or updating the object question	
			session.saveOrUpdate(q);	

			// commit transaction	
			tx.commit();	
			info("Transaction has been commited");	
			return true;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			error("Updating method failed!");	
			return false;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
	}	

	/**	
	 * Update a Question into the database based on the question object	
	 * 	
	 * @param question object	
	 * @return true if the question have been updated and false otherwise	
	 **/	
	@Override	
	public boolean updateQuestion(Question qNew, Question qOld) {	
		// it is easier to delete and create a question than to update it	
		// if delete question == true && if create question is true	
		// this method returns true	
		// else it return false	
		if ((deleteQuestion(qOld.getQuestionID()) == true) && (createQuestion(qNew) == true)) {	
			return true;	
		}else {	
		return false;	
		}	
	}	

	/**	
	 * Update a Question explanation into the database based on the questionID	
	 * 	
	 * @param questionID, updatedExplanation	
	 * @return true if the explanation have been updated and false otherwise	
	 **/	
	@Override	
	public boolean updateQuestionExplanation(int questionID, String updatedExplanation) {	

		Session session = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// get the object Question	
			info("getting a question by its id...");	
			q = getQuestion(questionID);	

			// change the correct answer.	
			info("updating the explanation of a question...");	
			q.setExplanation(updatedExplanation);	

			// saving or updating the new explanation	
			session.saveOrUpdate(q);	

			// commit transaction	
			tx.commit();	
			info("Transaction has been commited");	
			return true;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			error("Updating method failed!");	
			return false;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
	}	

	/**	
	 * Update a Question rating into the database based on the questionID	
	 * 	
	 * @param questionID, rating	
	 * @return true if the rating have been updated and false otherwise	
	 **/	
	@Override	
	public boolean updateQuestionRating(int questionID, int rating) {	

		Session session = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// get the object Question	
			info("getting the question by its Id...");	
			q = getQuestion(questionID);	

			// update the rating.	
			info("updating the rating of the question...");	
			q.setQuestionRating(rating);	

			// saving or updating the the object question	
			session.saveOrUpdate(q);	

			// commit transaction	
			tx.commit();	
			info("Transaction has been commited");	
			return true;	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			error("Updating method failed!");	
			return false;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
	}	

	/**	
	 * Delete a Question from the database based on the question ID	
	 * 	
	 * @param question object	
	 * @return true if the question have been deleted and false otherwise	
	 **/	
	@Override	
	public boolean deleteQuestion(int questionID) {	

		Session session = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	
			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// grabbing the question by ID	
			info("getting the question by its Id...");	
			q = getQuestion(questionID);	

			// deleting the question from the database	
			session.delete(q);	

			// commit transaction	
			tx.commit();	
			info("Transaction has been commited");	
			return true;	

		} catch (HibernateException e) {	
			error("Delete method did not work!");	
			if (tx != null)	
				tx.rollback();	
			return false;	

		} finally {	
			// closing the session	
			info("Closing the session");	
			session.close();	
		}	
	}	

	@Override	
	public Question getQuestionByName(String nameQ) {	

		Session session = null;	
		Criteria criteria = null;	
		Transaction tx = null;	
		Question q = new Question();	

		try {	

			// creating session	
			info("Opening session..");	
			session = sf.openSession();	

			// starting a transaction	
			info("Beginning transaction...");	
			tx = session.beginTransaction();	

			// creating criteria	
			info("creating criteria...");	
			criteria = session.createCriteria(Question.class);	
			criteria.add(Restrictions.eq("questionName", nameQ));	

			q = (Question) criteria.uniqueResult();	
			// if question is not null return the question object	
			if (q != null) {	
				info("Question is found!");	
				// returning the question	
				return q;	
			}	

			// committing the transaction	
			tx.commit();	
			info("commiting the transaction...");	

		} catch (NullPointerException e) {	
			e.printStackTrace();	
			error("getQuestion method failed!");	
			// if transaction is not null, rolls it back	
			if (tx != null)	
				tx.rollback();	
			// transaction has failed, so return null	
			info("getQuestion transaction has failed");	
			q = null;	

		} finally {	
			// closing the session	
			info("Closing the session...");	
			session.close();	
		}	
		return q;	
	}	
} 