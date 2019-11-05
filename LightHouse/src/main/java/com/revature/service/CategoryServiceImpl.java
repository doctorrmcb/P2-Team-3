package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.CategoryDAO;
import com.revature.dao.UserDAO;
import com.revature.pojo.Category;
import static com.revature.util.LoggerUtil.*;
@Component
public class CategoryServiceImpl implements CategoryService{
	
	/**
	 * The DAO that interacts with the database
	 */
	private static CategoryDAO catDAO;

	@Autowired
	public void setCategoryDAO(CategoryDAO catDAO) {
		this.catDAO = catDAO;
	}

	@Override
	public boolean createCategory(String catName) {
		debug("Checking to see if the category exists with the name: "+catName);
		Category cat = catDAO.getCat(catName);
		if((cat != null)||(catName =="{}")) {
		return false;
		}else {
			catDAO.createCategory(catName);
			return true;
		}
	}

	@Override
	public Category getCat(String catName) {
		// TODO Auto-generated method stub
		return catDAO.getCat(catName);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return catDAO.getAllCategory();
	}

	@Override
	public boolean updateCategory(String oldCatName, String newCatName) {
		// TODO Auto-generated method stub
		Category cat = catDAO.getCat(oldCatName);
		if((cat != null)&&(newCatName!="")) {
			catDAO.updateCategory(oldCatName, newCatName);
			return true;
		}else {
			error("failed both conditions of category existing and not being null");
		return false;
		}
	}

	@Override
	public boolean deleteCategory(String catName) {
		// TODO Auto-generated method stub
		if(catName!="") {
		Category cat = catDAO.getCat(catName);
		if(cat != null) {
			catDAO.deleteCategory(catName);
			return true;
			}
		}
		return false;
	}
	
}
