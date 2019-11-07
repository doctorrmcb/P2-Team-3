package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Category;
import com.revature.pojo.ControllerResponse;
import com.revature.pojo.Question;
import com.revature.service.CategoryServiceImpl;
import com.revature.service.QuestionServiceImpl;
import static com.revature.util.LoggerUtil.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
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

	public static int generateRandomIntIntRange(int min, int max) {

		Random r = new Random();

		return r.nextInt((max - min) + 1) + min;

	}

	@GetMapping("/quiz/{catName}")
	public List<Question> takeQuiz(@PathVariable String catName, HttpSession sess) {

		List<Question> qList = new ArrayList<Question>();
		List<Question> newQList = new ArrayList<Question>();
		int rando;
		qList = qService.getAllQuestionsbyCategory(catName);
		if (qList == null) {
			error("The list is empty!");
		} else {

			for (int count = 0; count < 10; count++) {
				rando = generateRandomIntIntRange(0, (qList.size() - 1));
				newQList.add(qList.get(rando));
			}
		}
		return newQList;
	}
}
