package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pojo.Post;
import com.revature.util.SessionFactoryUtil;


/**
 * This is the class that will get all Post objects from the databse
 * 
 * @author Robert Li
 */
public class PostDAOImpl implements PostDAO {

	
	
/**
 * This is the SessionFactory that will create sessions
 */
private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	

	/**
	 * This method gets a post from the database
	 * 
	 * @param postID is the ID of the post to retrieve
	 * @return Post returns the post
	 */
	@Override
	public Post getPost(int postID) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Post Post = (Post) sess.get(Post.class, postID);
		tx.commit();
		sess.close();
		return Post;
	}
	
	/**
	 * This method gets all posts from the database
	 * 
	 * @return postList This is the list of all posts
	 */
	
	@Override
	public List<Post> getAllPosts() {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Post.class);
		List<Post> postList = crit.list();
		tx.commit();
		sess.close();
		return postList;
	}
	
	/**
	 * This method inserts a post into the database
	 * 
	 * @param post This post is the post to be inserted
	 */

	@Override
	public void createPost(Post post) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(post);
		tx.commit();
		sess.close();
	}

	/**
	 * This method updates a post in the database
	 * 
	 * @param post is the post to be updated
	 */
	
	@Override
	public void updatePost(Post post) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(post);
		tx.commit();
		sess.close();
	}

	/**
	 * This method deletes a post from the database
	 * 
	 * @param post is the post to be deleted
	 */
	
	@Override
	public void deletePost(Post post) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(post);
		tx.commit();
		sess.close();
	}

}
