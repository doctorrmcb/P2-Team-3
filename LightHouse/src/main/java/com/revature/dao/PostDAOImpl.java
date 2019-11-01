package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.Post;
import com.revature.util.SessionFactoryUtil;

import static com.revature.util.LoggerUtil.*;

/**
 * This class implements CRUD methods for Post objects
 * 
 * @author Robert Li
 */
@Component
public class PostDAOImpl implements PostDAO {

	/**
	 * This is the SessionFactory that will create sessions
	 */
	private static SessionFactory sf;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	/**
	 * This method gets a post from the database
	 * 
	 * @param postID is the ID of the post to retrieve
	 * @return Post returns the post
	 */
	@Override
	public Post getPost(int postID) {
		info("Getting post with ID: " + postID);
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Post post = (Post) sess.get(Post.class, postID);
		info("Got post with ID:" + post.getPostID());
		tx.commit();
		sess.close();
		return post;
	}

	/**
	 * This method gets all posts from the database
	 * 
	 * @return postList This is the list of all posts
	 */

	@Override
	public List<Post> getAllPosts() {
		info("Getting all posts");
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Post.class);
		List<Post> postList = crit.list();
		info("Retrieved " + postList.size() + "posts");
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
