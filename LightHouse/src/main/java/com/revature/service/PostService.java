package com.revature.service;

import java.util.List;

import com.revature.pojo.ForumThread;
import com.revature.pojo.Post;
import com.revature.pojo.User;

/**
 * Interface for the PostService object
 * Acts as the liaison between the DAOs and the servlet
 * @author Robert Li
 *
 */
public interface PostService {
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
	 * Gets all posts belonging to a user
	 * 
	 * @param user who wrote the posts
	 * @return list of posts
	 */
	public List<Post> getPostsByUser(User user);
	
	/**
	 * Gets all posts belonging to a thread
	 * 
	 * @param thread
	 * @return list of posts
	 */
	
	
	public List<Post> getPostsByThread(ForumThread thread);

	
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
