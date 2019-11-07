package com.revature.service;

import java.util.List;

import com.revature.pojo.Category;

public interface CategoryService {
	
	/**
	 * Create a Category into the database based on the name
	 * @param catName
	 * @return true if the category have been created and false otherwise
	 **/
	public boolean createCategory(String catName);
	
	/**
	 * Read a Category from the database using the category name
	 * @param catName
	 * @return the category if the category was fetched and null otherwise
	 **/
	public Category getCat(String catName);
	
	/**
	 * Read all the Categories from the database
	 * @return a list of category if the table is not empty
	 * and null otherwise
	 **/
	public List<Category> getAllCategory();
	
	/**
	 * Update a Category from the database using the category name
	 * @param oldCatName, newCatName
	 * @return true if the category was updated and false otherwise
	 **/
	public boolean updateCategory(String oldCatName, String newCatName);
	
	/**
	 * Delete a Category from the database using the category name
	 * @param catName
	 * @return true if the category was deleted and false otherwise
	 **/
	public boolean deleteCategory(String catName);
	
	

}
