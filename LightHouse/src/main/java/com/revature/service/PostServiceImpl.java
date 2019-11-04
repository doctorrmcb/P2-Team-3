package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.PostDAO;
import com.revature.pojo.Post;

/**
 * The implementation of Post Service
 * Acts as liaison between DAOs and servlet
 * @author Robert Li
 *
 */
@Component
public class PostServiceImpl {
	
	private static PostDAO postDAO;
	
	@Autowired
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	
	/**
	 * Retrieves a post from the database based on ID
	 * 
	 * @param postID
	 * @return Post
	 */
	public Post getPost(int postID) {
		return postDAO.getPost(postID);
	}

	
	
	/**
	 * Gets all posts from the database
	 * 
	 * @return List of all posts
	 */
	public List<Post> getAllPosts(){
		return postDAO.getAllPosts();
	}

	
	/**
	 * Creates a post in the database
	 * 
	 * @param post
	 */
	public void createPost(Post post) {
		postDAO.createPost(post);
	}

	/**
	 * Updates a post in the database
	 * 
	 * @param post
	 */
	public void updatePost(Post post) {
		postDAO.updatePost(post);
	}

	/**
	 * Deletes a post in the databasea
	 * 
	 * @param post
	 */
	public void deletePost(Post post) {
		postDAO.deletePost(post);
	}
	
}
