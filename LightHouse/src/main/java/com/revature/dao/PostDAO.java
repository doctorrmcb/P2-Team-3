package com.revature.dao;

import java.util.List;

import com.revature.pojo.Post;

/**
 * This is the interface for PostDAOImpl
 * Ensures that CRUD methods will be implemented
 * 
 * @author Robert Li
 *
 */
public interface PostDAO {

	/**
	 * Retrieves a post from the database based on ID
	 * 
	 * @param postID
	 * @return Post
	 */
	public Post getPost(int postID);

	
	
	/**
	 * Gets all posts from the database
	 * 
	 * @return List of all posts
	 */
	public List<Post> getAllPosts();

	
	/**
	 * Creates a post in the database
	 * 
	 * @param post
	 */
	public void createPost(Post post);

	/**
	 * Updates a post in the database
	 * 
	 * @param post
	 */
	public void updatePost(Post post);

	/**
	 * Deletes a post in the databasea
	 * 
	 * @param post
	 */
	public void deletePost(Post post);
}
