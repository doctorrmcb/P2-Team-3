
package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.ControllerResponse;
import com.revature.pojo.Question;
import com.revature.pojo.User;
import com.revature.service.CategoryServiceImpl;
import com.revature.service.QuestionServiceImpl;
import com.revature.service.UserServiceImpl;
import static com.revature.util.LoggerUtil.*;

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
	public Question createQuestion(@PathVariable String category, @RequestBody Question q, HttpSession sess) {
	
	info("In Question controller creating question: " + q);
	Question checkQ = qService.getQuestionByName(q.getQuestionName());
	User user =(User) sess.getAttribute("user");
	
	if(checkQ != null) {
		return null;
	}
	
	if (q != null) {
		q.setStatus("pending");
		q.setCat(cService.getCat(category));
		//sess.getAttribute("user");
		q.setUser(user);
		qService.createQuestion(q);
		return q;
		
		}
	
	return null;
	
	}
	
	@PutMapping("/updateQuestion/{id}")
	public ControllerResponse updateQuestion(@PathVariable int id, @RequestBody String name, HttpSession sess) {
		if (true) {
			return cr;
		} else {
			return cr;
		}
	}

}
