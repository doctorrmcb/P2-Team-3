
package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.Question;
import com.revature.service.CategoryServiceImpl;
import com.revature.service.QuestionServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class QuestionController {
	
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



	@PostMapping("/createQuestion/{category}")
	public ControllerResponse createQuestion(@PathVariable String category, @RequestBody Question q, HttpSession sess) {
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
		q.setCat(cService.getCat(category));
		//sess.getAttribute("user");
		q.setUser(null);
		qService.createQuestion(q);
		response = "success";
		cr.setResponse(response);
		return cr;
		
		}
	
	return null;
	
	}

}
