package com.revature.dao;

import java.util.List;

import com.revature.pojo.Question;

/**
 * This is the interface for QuestionDAOImpl
 * It Ensures that CRUD methods are implemented
 * 
 * @author Pameni Gaelle & Roberto Rodriguez
 *
 */
public interface QuestionDAO {

	/**
	 * Create a Question into the database based on the question object
	 * @param question object
	 * @return true if the question have been created and false otherwise
	 **/
	public boolean createQuestion(Question q);

	/**
	 * Read a Question from the database using the question ID
	 * @param questionID
	 * @return the question if the question was fetched and null otherwise
	 **/
	public Question getQuestion(int questionID);
	
	/**
	 * Read a Question from the database using the question name
	 * @param nameQ
	 * @return the question if the question was fetched and null otherwise
	 **/
	public Question getQuestionByName(String nameQ);

	/**
	 * Read all the questions from the database
	 * @return a list of questions if the list is not empty and null otherwise
	 **/
	public List<Question> getAllQuestions();

	/**
	 * Read all the question from the database related to a particular category
	 * @param categoryName
	 * @return a list of questions if there are question related to
	 * that category and null otherwise
	 **/
	public List<Question> getAllQuestionsbyCategory(String categoryName);

	/**
	 * Update a Question into the database based on the question object
	 * @param question object
	 * @return true if the question have been updated and false otherwise
	 **/
	public boolean updateQuestion(Question qNew, Question qOld);

	/**
	 * Update a Question content into the database based on the questionID
	 * @param questionID, newName
	 * @return true if the question have been updated and false otherwise
	 **/
	public boolean updateQuestionName(int questionID, String newName);
	
	/**
	 * Update a Question correct answer into the database based on the questionID
	 * @param questionID, UpdatedAnswer
	 * @return true if the answer have been updated and false otherwise
	 **/
	public boolean updateCorrectAnswer(int questionID, String UpdatedAnswer);

	/**
	 * Update a Question explanation into the database based on the questionID
	 * @param questionID, updatedExplanation
	 * @return true if the explanation have been updated and false otherwise
	 **/
	public boolean updateQuestionExplanation(int questionID, String updatedExplanation);

	/**
	 * Update a Question rating into the database based on the questionID
	 * @param questionID, rating
	 * @return true if the rating have been updated and false otherwise
	 **/
	public boolean updateQuestionRating(int questionID, int rating);

	/**
	 * Delete a Question from the database based on the question ID
	 * @param question object
	 * @return true if the question have been deleted and false otherwise
	 **/
	public boolean deleteQuestion(int questionID);

}