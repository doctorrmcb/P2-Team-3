package com.revature.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.Category;
import com.revature.util.SessionFactoryUtil;
import static com.revature.util.LoggerUtil.*;

import java.util.ArrayList;
import java.util.List;


/**
 * This class implements CRUD methods for category objects
 *@author Pameni Gaelle & Roberto Rodriguez
 */
@Component
public class CategoryDAOImpl implements CategoryDAO {

	SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	/**
	 * Create a Category into the database based on the name
	 * @param catName
	 * @return true if the category have been created and false otherwise
	 **/
	@Override
	public boolean createCategory(String catName) {

		Session session = null;
		Transaction tx = null;

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// creating a category object
			Category cat = new Category();
			cat.setCategory(catName);

			// saving the category
			info("Persisting category...");
			session.save(cat);

			// commit transaction
			tx.commit();
			info("Transaction has been commited");

			// return true if category successfully created
			info("The new category has been successfully created");
			return true;

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("Creating method failed!");

			// if transaction is not null, rolls it back
			if (tx != null)
				tx.rollback();

			// transaction has failed, so return null
			info("creating a new category transaction has failed");

			// return false if category could not been created
			return false;

		} finally {
			// closing the session
			info("Closing the session...");
			session.close();
		}
	}

	/**
	 * Read a Category from the database using the category name
	 * @param catName
	 * @return the category if the category was fetched and null otherwise
	 **/
	@Override
	public Category getCat(String catName) {

		Session session = null;
		Criteria criteria = null;
		Transaction tx = null;
		Category cat = new Category();

		try {

			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// creating criteria
			criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.eq("category", catName));

			cat = (Category) criteria.uniqueResult();
			if (cat != null) {
				info("Category with catName " + catName + "has been found!");
				info("Category with catName " + catName + "is being returned");
				return cat;
			}
			// committing the transaction
			tx.commit();
			info("commiting the transaction");

		} catch (NullPointerException e) {
			e.printStackTrace();
			error("Reading method failed!");

			// if transaction is not null, rolls it back
			if (tx != null)
				tx.rollback();

			// transaction has failed, so set category to null
			info("reading  category transaction has failed");
			cat = null;

		} finally {
			// closing the session
			info("Closing the session");
			session.close();
		}
		return cat;
	}

	/**
	 * Read all the Categories from the database
	 * @return a list of category if the table is not empty
	 * and null otherwise
	 **/
	@Override
	public List<Category> getAllCategory() {

		Session session = null;
		Criteria criteria = null;
		List<Category> result = new ArrayList<Category>();

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// creating criteria
			info("Creating criteria...");
			criteria = session.createCriteria(Category.class);
			result = criteria.list();
			return result;

		} catch (NullPointerException e) {
			e.printStackTrace();
			// transaction has failed, so return null
			error("Reading list method failed!");
			result = null;

		} finally {
			// closing the session
			info("Closing the session");
			session.close();
		}
		return result;
	}

	/**
	 * Update a Category from the database using the category name
	 * @param oldCatName, newCatName
	 * @return true if the category was updated and false otherwise
	 **/
	@Override
	public boolean updateCategory(String oldCatName, String newCatName) {

		Session session = null;
		Transaction tx = null;
		Category cat = new Category();

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// getting the object category by name
			cat = getCat(oldCatName);

			// changing the category name.
			cat.setCategory(newCatName);

			// saving or updating the category
			session.saveOrUpdate(cat);

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
	 * Delete a Category from the database using the category name
	 * @param catName
	 * @return true if the category was deleted and false otherwise
	 **/
	@Override
	public boolean deleteCategory(String catName) {

		Session session = null;
		Transaction tx = null;
		Category cat = new Category();

		try {
			// creating session
			info("Opening session..");
			session = sf.openSession();

			// starting a transaction
			info("Beginning transaction...");
			tx = session.beginTransaction();

			// grabbing the category by name
			cat = getCat(catName);

			// deleting the object from the database
			session.delete(cat);

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
			// closing session
			session.close();
		}
	}
}