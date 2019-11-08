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

import com.revature.pojo.User;
import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

/**
 * This class implements CRUD methods for User objects
 * 
 * @author Robert Li
 *
 */
@Component
public class UserDAOImpl implements UserDAO {
	/**
	 * This is the SessionFactory that will create sessions
	 */
	private static SessionFactory sf;

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * This method gets a user from the database based on userID
	 * 
	 * @param UserID is the ID of the user to retrieve
	 * @return User returns the user
	 */
	@Override
	public User getUserByID(int userID) {
		info("Getting user with ID: " + userID);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		User user = (User) sess.get(User.class, userID);
		info("Got user with ID:" + user.getUserID());
		tx.commit();
		sess.close();
		return user;
	}

	/**
	 * This method gets a user from the database based on username
	 * 
	 * @param username is the username of the user to retrieve
	 * @return User returns the user
	 */
	@Override
	public User getUserByUsername(String username) {
		info("Getting user with username: " + username);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(User.class).add(Restrictions.eq("username", username));
		User user = (User) crit.uniqueResult();
		if (user != null) {
			info("Got user with username:" + user.getUsername());
		}
		tx.commit();
		sess.close();

		// Test lines.

		/*
		 * User user = new User(); user.setUsername("fakeUsername");
		 * user.setPassword("fakePassword");
		 */
		return user;
	}

	/**
	 * This method gets all users from the database
	 * 
	 * @return userList This is the list of all users
	 */

	@Override
	public List<User> getAllUsers() {
		info("Getting all Users");
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(User.class);
		List<User> UserList = crit.list();
		info("Retrieved " + UserList.size() + "users");
		tx.commit();
		sess.close();
		return UserList;
	}

	/**
	 * This method inserts a user into the database
	 * 
	 * @param User This user is the user to be inserted
	 */

	@Override
	public void createUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(user);
		tx.commit();
		sess.close();
	}

	/**
	 * This method updates a User in the database
	 * 
	 * @param User is the User to be updated
	 */

	@Override
	public void updateUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(user);
		tx.commit();
		sess.close();
	}

	/**
	 * This method deletes a User from the database
	 * 
	 * @param User is the User to be deleted
	 */

	@Override
	public void deleteUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(user);
		tx.commit();
		sess.close();
	}

}
