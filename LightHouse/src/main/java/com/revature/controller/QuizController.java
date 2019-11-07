package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Category;
import com.revature.pojo.ControllerResponse;
import com.revature.pojo.Question;
import com.revature.service.CategoryServiceImpl;
import com.revature.service.QuestionServiceImpl;

@RestController
@CrossOrigin("*")
public class QuizController {
	
	private QuestionServiceImpl qService;
	
	private CategoryServiceImpl catService;
	
	@Autowired
	public void setQuestionServiceImpl(QuestionServiceImpl qService) {
		this.qService = qService;
	}
	
	@Autowired
	public void setCategoryServiceImpl(CategoryServiceImpl catService) {
		this.catService = catService;
	}
	@GetMapping("/quiz")
	public ControllerResponse takeQuiz(@RequestBody Category cat, Question q, HttpSession sess) {
	
	return cr;
	}
}
