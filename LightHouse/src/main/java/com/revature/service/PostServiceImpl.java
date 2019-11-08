package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.PostDAO;
import com.revature.pojo.ForumThread;
import com.revature.pojo.Post;
import com.revature.pojo.User;

/**
 * The implementation of Post Service
 * Acts as liaison between DAOs and servlet
 * @author Robert Li
 *
 */
@Component
public class PostServiceImpl implements PostService{
	
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
	 * Gets all posts belonging to a user
	 * 
	 * @param user who wrote the posts
	 * @return list of posts
	 */
	public List<Post> getPostsByUser(User user){
		return postDAO.getPostsByUser(user);
	}
	
	/**
	 * Gets all posts belonging to a thread
	 * 
	 * @param thread
	 * @return list of posts
	 */
	public List<Post> getPostsByThread(ForumThread thread){
		return postDAO.getPostsByThread(thread);
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
