package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.pojo.Category;
import com.revature.pojo.ControllerResponse;
import com.revature.service.CategoryServiceImpl;
import static com.revature.util.LoggerUtil.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CategoryController {

	private CategoryServiceImpl catService;
	
	@Autowired
	public void setCategoryService(CategoryServiceImpl catService) {
		this.catService = catService; 
	}
	
	@PostMapping("/category")
	public ControllerResponse createCategory(@RequestBody String catName, ModelMap modelMap, HttpSession sess) {
		info(catName + "");
		catName = catName.replace("{\"name\":\"", "");
		catName = catName.replace("}", "");
		catName = catName.replace("\"", "");
		String response = "";
		ControllerResponse cr = new ControllerResponse();
		boolean checkCat = catService.createCategory(catName);
		if(checkCat == false) {
			response = "Category already exists or Category name cannot be empty!";
			cr.setResponse(response);
			return cr;
		}else
			response = "Category created!";
		cr.setResponse(response);
		return cr;
		
	}
	
	/**
	 * Retrieves all category
	 * @param 
	 * @return
	 */
	@GetMapping("/category")
	public List<Category> getCategories(){
		List<Category> catList = new ArrayList<Category>();
		catList = catService.getAllCategory();
		return catList;
	}
	

}
