package com.revature.dao;

import static com.revature.util.LoggerUtil.error;
import static com.revature.util.LoggerUtil.info;

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

import com.revature.pojo.Leaderboard;
import com.revature.util.SessionFactoryUtil;

/**
 * This class implements CRUD methods for Leaderboard objects
 * 
 * @author Pameni Gaelle & Roberto Rodriguez
 */

@Component
public class LeaderboardDAOImpl implements LeaderboardDAO {

	SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * Create a Leaderboard into the database based on the object leaderboard
	 * 
	 * @param lead
	 * @return true if the leaderboard have been created and false otherwise
	 **/
	@Override
	public boolean createLeaderboard(Leaderboard lead) {

		Session session = null;
		Transaction tx = null;
		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// saving the leaderboard
			info("Saving the leaderboard...");
			session.save(lead);

			// committing transaction
			tx.commit();

			// return true if leaderboard successfully created
			info("Transaction has been commited");
			return true;

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("Creating method failed!");

			// if transaction is not null, rolls it back
			if (tx != null)
				tx.rollback();
			info("creating a new leaderboard transaction has failed");

			// return false if leaderboard could not been created
			return false;

		} finally {
			// closing the session
			info("Closing the session...");
			session.close();
		}
	}

	/**
	 * Read a leaderboard from the database using the category name
	 * 
	 * @param catName
	 * @return a list of leaderboard if the category exists into the database and
	 *         null otherwise
	 **/
	@Override
	public List<Leaderboard> getLeadByCat(String catName) {

		Session session = null;
		Criteria criteria = null;
		CategoryDAOImpl cat = new CategoryDAOImpl();
		List<Leaderboard> result = new ArrayList<Leaderboard>();

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// Creating a criteria
			info("Creating criteria...");
			criteria = session.createCriteria(Leaderboard.class);

			// adding a restriction to the fetch
			info("adding a restriction to the fetch...");
			criteria.add(Restrictions.eq("cat", cat.getCat(catName)));

			// return a list if there is at least one leaderboard
			// related to that category name
			result = criteria.list();
			info(result.toString());
			return result;

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("reading list method failed!");

			// transaction has failed, so return null
			info("reading the leaderboard by category transaction has failed");

			// return null if there is no leaderboard
			// related to that category name
			result = null;

		} finally {
			// closing the session
			info("Closing the session...");
			session.close();
		}

		return result;
	}

	/**
	 * Read a leaderboard from the database using the Username
	 * 
	 * @param username
	 * @return a list of leaderboard if the username exists into the database and
	 *         null otherwise
	 **/
	@Override
	public List<Leaderboard> getLeadByUser(String username) {

		Session session = null;
		Criteria criteria = null;
		List<Leaderboard> result = new ArrayList<Leaderboard>();

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// Creating a criteria
			info("Creating criteria...");
			criteria = session.createCriteria(Leaderboard.class);

			// adding a restriction to the fetch
			info("adding a restriction to the fetch...");
			criteria.add(Restrictions.eq("userName", username));

			// return a list if there is at least one leaderboard
			// related to that username
			result = criteria.list();
			info(result.toString());
			return result;

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("reading list method failed!");

			// transaction has failed, so return null
			info("reading the leaderboard by username transaction has failed");

			// return null if there is no leaderboard
			// related to that username
			result = null;

		} finally {
			// closing the session
			info("Closing the session...");
			session.close();
		}

		return result;
	}

	/**
	 * Delete a leaderboard from the database using the leadID
	 * 
	 * @param leadID
	 * @return true if the leaderboard was deleted and false otherwise
	 **/
	@Override
	public boolean deleteLeadByID(int leadID) {

		Session session = null;
		Transaction tx = null;
		Leaderboard lead = new Leaderboard();

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// grabbing record from the database
			lead = getLeaderboard(leadID);

			// deleting the record from the leaderboard table
			session.delete(lead);

			// committing transaction
			tx.commit();
			info("Transaction has been commited");
			return true;

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("Delete method did not work!");

			// if transaction is not null, rolls it back
			if (tx != null)
				tx.rollback();
			info("deleting an existing leaderboard transaction has failed");

			// return false if leaderboard could not been deleted
			return false;

		} finally {
			// closing the session
			info("Closing the session...");
			session.close();
		}

	}

	/**
	 * Read a leaderboard from the database using the leadID
	 * 
	 * @param leadID
	 * @return a leaderboard if the leadID exists into the database and null
	 *         otherwise
	 **/
	@Override
	public Leaderboard getLeaderboard(int leadID) {

		Session session = null;
		Criteria criteria = null;
		Transaction tx = null;
		Leaderboard lead = new Leaderboard();

		try {

			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// creating a criteria
			criteria = session.createCriteria(Leaderboard.class);
			criteria.add(Restrictions.eq("leadID", leadID));
			lead = (Leaderboard) criteria.uniqueResult();

			if (lead != null) {
				info("Leaderboard record has been found" + lead);
				return lead;
			}

			// commiting the transaction
			tx.commit();
			info("commiting the transaction");

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("getLeaderboard method has failed!");

			// if transaction is not null, rolls it back
			if (tx != null)
				tx.rollback();

			// transaction has failed, so return null
			info("getQuestion transaction has failed");
			lead = null;

		} finally {
			// closing the session
			info("Closing the session");
			session.close();
		}
		return lead;
	}

}