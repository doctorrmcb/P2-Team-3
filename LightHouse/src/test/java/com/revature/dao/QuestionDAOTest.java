package com.revature.dao;

import static com.revature.util.LoggerUtil.error;
import static com.revature.util.LoggerUtil.info;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.pojo.Category;
import com.revature.pojo.Question;
import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDAOTest {

	@Mock
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Spy
	User user = new User();

	@Spy

	CategoryDAOImpl category = new CategoryDAOImpl();

	@Spy
	UserDAOImpl users = new UserDAOImpl();

	@Spy
	QuestionDAOImpl question = new QuestionDAOImpl();

	@Spy
	Question quest = question.getQuestion(100);

	@Spy
	NullPointerException exceptionSpy = new NullPointerException("Catching NullPointerException");

	@Spy
	NullPointerException nullexc = new NullPointerException("Catching NullPointerException");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This method tests if a boolean true is being returned when a question is
	 * being created
	 */
	@Test
	public void testPassCreateQuestion() {
		info("testPassCreateQuestion running...");
		Question q = new Question();
		Category cat = new Category();
		cat = category.getCat("SQL Basics");
		q.setCat(cat);
		q.setQuestionName("Syntax for selecting all fields from a table?");
		q.setCorrectAnswer("SELECT * FROM TABLE_NAME");
		q.setWrongAnswer1("SELECT ALL FROM TABLE_NAME");
		q.setWrongAnswer2("GRAB ALL FROM TABLE_NAME");
		q.setWrongAnswer3("GRAB * FROM TABLE_NAME");
		q.setExplanation("SQL uses * symbol to grab all fields from a column, and SELECT is the correct keyword");
		q.setQuestionRating(5);
		user = users.getUserByUsername("trainerUsername");
		q.setUser(user);
		q.setStatus("accepted");
		assertTrue(question.createQuestion(q));
		info("new question created...");
	}
	
	/**
	 * This method tests if a boolean false is being returned when a question failed
	 * for any reason during creation
	 */
	@Test
	public void testFailCreateQuestion() {
		info("testFailCreateQuestion running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			assertTrue(question.createQuestion(quest));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailCreateQuestion");
		}
	}

	/**
	 * This method tests if an object question is being returned when reading a
	 * question from database
	 */
	@Test
	public void testPassGetQuestion() {
		info("testPassGetQuestion running...");
		Category cat = new Category();
		user = users.getUserByUsername("trainerUsername");
		cat = category.getCat("SQL Basics");
		Question q = new Question(100, cat, "Syntax for selecting all fields from a table?", "SELECT * FROM TABLE_NAME",
				"SELECT ALL FROM TABLE_NAME", "GRAB ALL FROM TABLE_NAME", "GRAB * FROM TABLE_NAME",
				"SQL uses * symbol to grab all fields from a column, and SELECT is the correct keyword", 5, user,
				"accepted");
		assertEquals(q, question.getQuestion(100));
		info("question " + q + " has been fetched from question table");
	}

	/**
	 * This method tests if an object null is being returned when a question failed
	 * failed being read from database
	 */
	@Test
	public void testFailGetQuestion() {
		Question testQ = new Question();
		info("testFailCreateQuestion running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			assertEquals(testQ, question.getQuestion(100));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailGetQuestion");
		}
	}

	
	/**
	 * This method tests if an object null is not returned when reading from table
	 * containing questions
	 */
	@Test
	public void testPassListReadQuestions() {
		info("testPassListReadQuestions running...");
		List<Question> qList = new ArrayList<Question>();
		qList = question.getAllQuestions();
		info("the category into the database are :" + qList);
		assertThat(qList.isEmpty(), is(false));
	}

	/**
	 * This method tests if an object null is returned when reading from empty table
	 */
	@Test
	public void testFailListReadQuestions() {
		info("testFailListReadQuestions running ...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			List<Question> qList = new ArrayList<Question>();
			info("the category into the database are :" + qList);
			assertThat(qList.isEmpty(), is(true));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailListReadQuestions");
		}
	}

	/**
	 * This method tests if a boolean true is being returned when updating the
	 * content of a question into the question table
	 */
	@Test
	public void testPassUpdateQuestionName() {
		info("testPassupdateQuestionName running...");
		int questionID = 100;
		String newName = "Can you help me with this method? ";
		assertTrue(question.updateQuestionName(questionID, newName));
		info("the content of the question with Id" + questionID + " has been updated to " + newName);
	}

	/**
	 * This method tests if a boolean false is being returned when updating the
	 * content of a question into the question table failed
	 */
	@Test
	public void testFailUpdateQuestionName() {
		info("testFailUpdateQuestionName running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			int questionID = 100;
			String newName = "Did this method work?";
			assertFalse(question.updateQuestionName(questionID, newName));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailUpdateQuestionName");
		}
	}

	/**
	 * This method tests if a list of question is returned when Fetching question
	 * from table by category
	 */
	@Test
	public void testPassListReadQuestionbyCategory() {
		info("testPassListReadQuestionbyCategory running...");
		List<Question> qList = new ArrayList<Question>();
		qList = question.getAllQuestionsbyCategory("SQL Basics");
		assertThat(qList.isEmpty(), is(false));
		info("the list " + qList + " has been fetched from Question table because they have the same category");
	}

	/**
	 * This method tests if a null object is being returned when fetching questions
	 * from table by category
	 */
	@Test
	public void testFailListReadQuestionbyCategory() {
		info("testFailListReadQuestionbyCategory running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			List<Question> qList = new ArrayList<Question>();
			assertThat(qList.isEmpty(), is(true));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailListReadQuestionbyCategory");
		}
	}

	/**
	 * This method tests if a boolean true is being returned when updating the
	 * correct answer of a question into the question table
	 */
	@Test
	public void testPassUpdateCorrectAnswer() {
		info("testPassUpdateCorrectAnswer running...");
		int questionID = 50;
		String newName = "This updating method is working";
		assertTrue(question.updateQuestionName(questionID, newName));
		info("the answer of the question with Id " + questionID + " has been updated to " + newName);
	}

	/**
	 * This method tests if a boolean false is being returned when failing to update
	 * the correct answer of a question into the question table
	 */
	@Test
	public void testFailUpdateCorrectAnswer() {
		info("testFailUpdateCorrectAnswer running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			info("testPassUpdateCorrectAnswer test is being run");
			int questionID = 50;
			String newName = "This updating method is working";
			assertFalse(question.updateQuestionName(questionID, newName));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailUpdateCorrectAnswer");
		}
	}

	/**
	 * This method tests if a boolean true is being returned when updating the
	 * explanation of a question into the question table
	 */
	@Test
	public void testPassUpdateExplanation() {
		info("testPassUpdateExplanation running...");
		int questionID = 50;
		String explanation = "This explanation is being updated";
		assertTrue(question.updateQuestionExplanation(questionID, explanation));
		info("the explanation of the question with Id " + questionID + " has been updated to " + explanation);
	}

	/**
	 * This method tests if a boolean false is being returned when failing to update
	 * the explanation of a question into the question table
	 */
	@Test
	public void testFailUpdateExplanation() {
		info("testPassUpdateExplanation running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			int questionID = 50;
			String explanation = "This explanation is being updated";
			assertFalse(question.updateQuestionExplanation(questionID, explanation));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailUpdateExplanation");
		}
	}

	/**
	 * This method tests if a boolean true is being returned when updating the
	 * rating of a question into the question table
	 */
	@Test
	public void testPassUpdateRating() {
		info("testPassUpdateRating running...");
		int questionID = 50;
		int rating = 3;
		assertTrue(question.updateQuestionRating(questionID, rating));
		info("the rating of the question with Id " + questionID + " has been updated to " + rating);
	}

	/**
	 * This method tests if a boolean false is being returned when failing to update
	 * the rating of a question into the question table
	 */
	@Test
	public void testFailUpdateRating() {
		info("testPassUpdateRating running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			int questionID = 50;
			int rating = 3;
			assertFalse(question.updateQuestionRating(questionID, rating));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailUpdateRating");
		}
	}

	/**
	 * This method tests if a boolean true is being returned when deleting question
	 * from the question table
	 */
	@Test
	public void testPassDeleteQuestion() {
		info("testPassDeleteQuestion running...");
		int questionID = 50;
		assertTrue(question.deleteQuestion(questionID));
		info("the question with the ID " + questionID + " has been deleted from question table");
	}

	/**
	 * This method tests if a boolean false is being returned when failing to delete
	 * a question from the question table
	 */
	@Test
	public void testFailDeleteQuestion() {
		info("testPassDeleteQuestion running...");
		try {
			question.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			int questionID = 50;
			assertFalse(question.deleteQuestion(questionID));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching " + e + " from testFailDeleteQuestion");
		}
	}
}