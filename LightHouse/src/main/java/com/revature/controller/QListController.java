package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.Question;
import com.revature.service.CategoryServiceImpl;
import com.revature.service.QuestionServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class QListController {
	
	
		
		private QuestionServiceImpl qService;
		private CategoryServiceImpl cService;
		
		@Autowired
		public void setQuestionService(QuestionServiceImpl qService) {
			this.qService = qService;
		}
		
		@Autowired
		public void setcService(CategoryServiceImpl cService) {
			this.cService = cService;
		}

		@GetMapping("/viewQuestions/{category}")
		public List<Question> viewAllQuestions(@PathVariable String category){
			List<Question> qList = new ArrayList<Question>();
			qList = qService.getAllQuestionsbyCategory(category);
			return qList;
		}
}
