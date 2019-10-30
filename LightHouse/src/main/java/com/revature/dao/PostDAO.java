package com.revature.dao;

import java.util.List;

import com.revature.pojo.Post;

public interface PostDAO {

	public Post getPost(int PostID);

	public List<Post> getAllPosts();

	public void createPost(Post post);

	public void updatePost(Post post);

	public void deletePost(Post post);
}
