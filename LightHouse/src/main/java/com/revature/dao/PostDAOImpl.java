package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pojo.Post;
import com.revature.util.SessionFactoryUtil;


/*
 * Author - Robert Li
 */
public class PostDAOImpl implements PostDAO {

private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@Override
	public Post getPost(int postID) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Post Post = (Post) sess.get(Post.class, postID);
		tx.commit();
		sess.close();
		return Post;
	}

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

	@Override
	public void createPost(Post post) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(post);
		tx.commit();
		sess.close();
	}

	@Override
	public void updatePost(Post post) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(post);
		tx.commit();
		sess.close();
	}

	@Override
	public void deletePost(Post post) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(post);
		tx.commit();
		sess.close();
	}

}
