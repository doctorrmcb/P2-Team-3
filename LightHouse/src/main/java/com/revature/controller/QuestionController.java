package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.Question;
import com.revature.service.QuestionServiceImpl;

@RestController
@CrossOrigin("*")
public class QuestionController {
	
	private QuestionServiceImpl qService;
	
	@Autowired
	public void setQuestionService(QuestionServiceImpl qService) {
		this.qService = qService;
	}
	
	
	@PostMapping("/createQuestion")
	public ControllerResponse createQuestion(@RequestBody Question q, HttpSession sess) {
	ControllerResponse cr = new ControllerResponse();
	String response = "";
	
	Question checkQ = qService.getQuestionByName(q.getQuestionName());
	
	if(checkQ != null) {
		response = "Question already exists";
		cr.setResponse(response);
		return cr;
	}
	
	if (q != null) {
		q.setStatus("pending");
		//sess.getAttribute("user");
		q.setUser(null);
		qService.createQuestion(q);
		response = "Question Created";
		cr.setResponse(response);
		return cr;
		
		}
	
	return null;
	
	}
}
