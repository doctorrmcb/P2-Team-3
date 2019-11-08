
package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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


	/**
	 * Creates a question in the database
	 * @param category  category the question is in
	 * @param q 		question to be created
	 * @param sess		HttpSession
	 * @return que		The question created in the database			
	 */
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
		Question que = qService.getQuestionByName(q.getQuestionName());
		return que;
		
		}
	
	return null;
	
	}
	
	/**
	 * Updates a question
	 * @param id		id of the question to be updated
	 * @param name		the new question the Question is asking
	 * @param sess		HttpSession
	 * @return			A response to help dictate logic flow
	 */
	@PutMapping("/updateQuestionName/{id}")
	public ControllerResponse updateQuestionName(@PathVariable int id, @RequestBody String name, HttpSession sess) {
		ControllerResponse cr = new ControllerResponse();
		name = name.replace("{\"newcontent\":\"", "");
		name = name.replace("\"}", "");
		boolean check = qService.updateQuestionName(id, name);
		if (check) {
			cr.setResponse("success");
			return cr;
		} else {
			cr.setResponse("fail");
			return cr;
		}
	}
	
	/**
	 * Updates the correct answer to a question
	 * @param id		id of the question to be updated
	 * @param name		The new correct answer
	 * @param sess		Http Session
	 * @return			Controller response to help dictate logic flow
	 */
	@PutMapping("/updateQuestionAnswer/{id}")
	public ControllerResponse updateQuestionAnswer(@PathVariable int id, @RequestBody String name, HttpSession sess) {
		ControllerResponse cr = new ControllerResponse();
		name = name.replace("{\"newanswer\":\"", "");
		name = name.replace("\"}", "");
		boolean check = qService.updateCorrectAnswer(id, name);
		if (check) {
			cr.setResponse("success");
			return cr;
		} else {
			cr.setResponse("fail");
			return cr;
		}
	}
	
	/**
	 * Updates the explanation for the correct answer
	 * @param id		id of the question to be updated
	 * @param name		new explanation for the correct answer
	 * @param sess		Http Session
	 * @return			Controller response to help dictate logic flow
	 */
	@PutMapping("/updateQuestionExplanation/{id}")
	public ControllerResponse updateQuestionExplanation(@PathVariable int id, @RequestBody String name, HttpSession sess) {
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		name = name.replace("{\"newexplanation\":\"", "");
		name = name.replace("\"}", "");
		boolean check = qService.updateQuestionExplanation(id, name);
		if (check) {
			response = "success";
			cr.setResponse(response);
			return cr;
		} else {
			response = "success";
			cr.setResponse("success");
			return cr;
		}
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	public ControllerResponse updateQuestionExplanation(@PathVariable int id, HttpSession sess) {
		ControllerResponse cr = new ControllerResponse();
		String response = "";
		boolean check = qService.deleteQuestion(id);
		if (check) {
			response = "success";
			cr.setResponse(response);
			return cr;
		} else {
			response = "success";
			cr.setResponse("success");
			return cr;
		}
	}
	

}
