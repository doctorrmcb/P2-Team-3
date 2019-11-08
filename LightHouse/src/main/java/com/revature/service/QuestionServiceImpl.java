package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.QuestionDAO;
import com.revature.pojo.Question;
import static com.revature.util.LoggerUtil.*;

@Component
public class QuestionServiceImpl implements QuestionService{

	
	/**
	 * The DAO that interacts with the database
	 */
	private static QuestionDAO qDAO;

	@Autowired
	public void setQuestionDAO(QuestionDAO qDAO) {
		this.qDAO = qDAO;
	}

	@Override
	public boolean createQuestion(Question q) {
		// TODO Auto-generated method stub
		debug("Checking to see if the question exists");
		Question newQ = qDAO.getQuestionByName(q.getQuestionName());
		if( newQ!= null) {
		return false;
		}else {
			qDAO.createQuestion(q);
			return true;
		}
		
	}

	@Override
	public Question getQuestion(int questionID) {
		// TODO Auto-generated method stub
		return qDAO.getQuestion(questionID);
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return qDAO.getAllQuestions();
	}

	@Override
	public List<Question> getAllQuestionsbyCategory(String categoryName) {
		// TODO Auto-generated method stub
		return qDAO.getAllQuestionsbyCategory(categoryName);
		
	}

	@Override
	public boolean updateQuestion(Question qNew, Question qOld) {
		// TODO Auto-generated method stub
		return qDAO.updateQuestion(qNew, qOld);
	}

	@Override
	public boolean updateQuestionName(int questionID, String newName) {
		debug("Checking to see if the question exists");
		Question q = qDAO.getQuestion(questionID);
		if((q!=null)&&(newName!="")) {
			qDAO.updateQuestionName(questionID, newName);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean updateCorrectAnswer(int questionID, String UpdatedAnswer) {
		debug("Checking to see if the question exists");
		Question q = qDAO.getQuestion(questionID);
		if((q!=null)&&(UpdatedAnswer!="")) {
			qDAO.updateCorrectAnswer(questionID, UpdatedAnswer);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateQuestionExplanation(int questionID, String updatedExplanation) {
		// TODO Auto-generated method stub
		debug("Checking to see if the question exists");
		Question q = qDAO.getQuestion(questionID);
		if((q!=null)&&(updatedExplanation!="")) {
			qDAO.updateQuestionExplanation(questionID, updatedExplanation);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean updateQuestionRating(int questionID, int rating) {
		// TODO Auto-generated method stub
		debug("Checking to see if the question exists");
		Question q = qDAO.getQuestion(questionID);
		if((q!=null)&&(rating > 0 && rating <=5)) {
			qDAO.updateQuestionRating(questionID, rating);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean deleteQuestion(int questionID) {
		// TODO Auto-generated method stub
		return qDAO.deleteQuestion(questionID);
	}

	@Override
	public Question getQuestionByName(String nameQ) {
		// TODO Auto-generated method stub
		return qDAO.getQuestionByName(nameQ);
	}

}
