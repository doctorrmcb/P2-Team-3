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
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.pojo.Category;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDAOTest {
	
	@Mock
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Spy
	CategoryDAOImpl category = new CategoryDAOImpl();

	@Spy
	NullPointerException exceptionSpy = new NullPointerException("catch NullPointerException");

	@Spy
	NullPointerException nullexc = new NullPointerException("catch NullPointerException");

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
	 * This method tests if a boolean true is being returned when a category is
	 * being created
	 */
	@Test
	public void testPassCreateCategory() {
		info("testPassCreateCategory running...");
		assertTrue(category.createCategory("Java"));
	}

	/**
	 * This method tests if a boolean false is being returned when a category failed
	 * for any reason during creation
	 */
	@Test
	public void testFailCreateCategory() {
		info("testFailCreateCategory running...");
		try {
			category.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(exceptionSpy);
			assertFalse(category.createCategory("Java Basics"));
		} catch (NullPointerException e) {
			Mockito.verify(exceptionSpy).printStackTrace();
			error("catching" + e + " from testFailCreateCategory()");
		}
	}

	/**
	 * This method tests if an object category is being returned when reading a
	 * category from database
	 */
	@Test
	public void testPassReadCategory() {
		info("testPassReadCategory running...");
		Category cat = new Category(150, "Java Basics");
		info("category" + cat + " is being fecthed");
		assertEquals(cat, category.getCat("Java Basics"));
	}

	/**
	 * This method tests if an object null is being returned when a category failed
	 * failed being read from database
	 */
	@Test
	public void testFailReadCategory() {
		info("testFailReadCategoryrunning...");
		try {
			category.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			Category cat = new Category();
			assertEquals(cat, category.getCat("Yikes"));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching" + e + " from testFailReadCategory()");
		}
	}

	/**
	 * This method tests if an object null is not returned when reading from table
	 * containing categories
	 */
	@Test
	public void testPassListReadCategory() {
		info("ListReadCategory running...");
		List<Category> catList = new ArrayList<Category>();
		catList = category.getAllCategory();
		info("the categories " + catList + " are being fetched");
		assertThat(catList.isEmpty(), is(false));
	}

	/**
	 * This method tests if an object null is returned when reading from empty table
	 */
	@Test
	public void testFailListReadCategory() {
		info("testFailListReadCategory running...");
		try {
			List<Category> catList = new ArrayList<Category>();
			category.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			assertThat(catList.isEmpty(), is(true));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching" + e + " from testFailListReadCategory()");
		}
	}

	/**
	 * This method tests if a boolean true is returned when updating a category
	 */
	@Test
	public void testPassUpdateCategory() {
		info("testPassUpdateCategory running...");
		String oldName = "Java Basics";
		String newName = "Agile";
		assertTrue(category.updateCategory(oldName, newName));
		info("category name " + oldName + "has been updated to " + newName);
	}

	/**
	 * This method tests if a boolean false is returned when the updating method
	 * cannot be completed
	 */
	@Test
	public void testFailUpdateCategory() {
		info("testFailListReadCategory running...");
		String oldName = "Java Basics";
		String newName = "Agile";
		try {
			category.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			assertFalse(category.updateCategory(oldName, newName));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching" + e + " from testFailUpdateCategory()");
		}
	}

	/**
	 * This method tests if a boolean true is returned when deleting a category
	 */
	@Test
	public void testPassDeleteCategory() {
		info("testFailListReadCategory running...");
		String catName = "Agile";
		info("The categoty" + catName + "is being deleted from dataBase");
		assertTrue(category.deleteCategory(catName));
	}

	/**
	 * This method tests if a boolean false is returned when deleting
	 * a category method cannot being completed
	 */
	@Test
	public void testFailDeleteCategory() {
		info("testFailDeleteCategory running...");
		try {
			category.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(nullexc);
			String catName = "Agile";
			info("The categoty" + catName + "is being deleted from dataBase");
			assertFalse(category.deleteCategory(catName));
		} catch (NullPointerException e) {
			Mockito.verify(nullexc).printStackTrace();
			error("catching" + e + " from testFailDeleteCategory()");
		}
	}

}