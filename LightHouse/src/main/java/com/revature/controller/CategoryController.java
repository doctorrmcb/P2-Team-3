package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Category;
import com.revature.pojo.ControllerResponse;
import com.revature.service.CategoryServiceImpl;
import static com.revature.util.LoggerUtil.*;
@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

	private CategoryServiceImpl catService;
	
	@Autowired
	public void setCategoryService(CategoryServiceImpl catService) {
		this.catService = catService; 
	}
	
	@PostMapping("/category")
	public ControllerResponse createCategory(@RequestBody String catName, ModelMap modelMap, HttpSession sess) {
		info(catName + "");
	
		String response = "";
		ControllerResponse cr = new ControllerResponse();
		boolean checkCat = catService.createCategory(catName);
		if(checkCat == false) {
			response = "Category already exists!";
			cr.setResponse(response);
			return cr;
		}else
			response = "Question created!";
		cr.setResponse(response);
		return cr;
		
	}

}
