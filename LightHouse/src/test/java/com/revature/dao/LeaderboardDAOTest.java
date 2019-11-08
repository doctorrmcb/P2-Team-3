package com.revature.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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
import com.revature.pojo.Leaderboard;
import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;
import static com.revature.util.LoggerUtil.*;

@RunWith(MockitoJUnitRunner.class)
public class LeaderboardDAOTest {

	@Mock
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@Spy
	CategoryDAOImpl category = new CategoryDAOImpl();

	@Spy
	UserDAOImpl users = new UserDAOImpl();

	@Spy
	LeaderboardDAOImpl leaderboard = new LeaderboardDAOImpl();

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

	@Test
	public void testPassCreateLeaderboard() {
		info("testPassCreateLeaderboard running...");
		Leaderboard lead = new Leaderboard();
		User user = new User();
		Category cat = new Category();
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime finish = LocalDateTime.of(2019, Month.NOVEMBER, 2, 4, 39, 00);
		user = users.getUserByUsername("trainerUsername");
		cat = category.getCat("SQL Basics");
		lead.setQuizScore(97.5);
		lead.setCat(cat);
		lead.setUsername(user.getUsername());
		lead.setTimeTaken(Duration.between(finish, current).getSeconds());
		info(Duration.between(current, finish).toString());
		lead.setDateTaken(Date.valueOf(LocalDate.now()));
		assertTrue(leaderboard.createLeaderboard(lead));
	}

	@Test
	public void testFailCreateLeaderboard() {
		info("testPassCreateLeaderboard running...");
		try {
			leaderboard.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(exceptionSpy);
			Leaderboard lead = new Leaderboard();
			assertFalse(leaderboard.createLeaderboard(lead));
		} catch (NullPointerException e) {
			Mockito.verify(exceptionSpy).printStackTrace();
			error("catching" + e + " from testFailCreateLeaderboard()");
		}
	}

	@Test
	public void testPassReadLeadByCat() {
		info("testPassReadLeadByCat running...");
		List<Leaderboard> leadList = new ArrayList<Leaderboard>();
		leadList = leaderboard.getLeadByCat("SQL Basics");
		info(leadList.toString());
		assertThat(leadList.isEmpty(), is(false));
	}

	@Test
	public void testFailReadLeadByCat() {
		info("testFailReadLeadByCat running...");
		List<Leaderboard> leadList = new ArrayList<Leaderboard>();
		try {
			leaderboard.setSessionFactory(sf);
			leadList = leaderboard.getLeadByCat("");
			when(sf.openSession()).thenThrow(exceptionSpy);
			assertThat(leadList.isEmpty(), is(true));
		} catch (NullPointerException e) {
			Mockito.verify(exceptionSpy).printStackTrace();
			error("catching" + e + " from testFailReadLeadByCat()");
		}
	}

	@Test
	public void testPassReadLeadByUser() {
		info("testPassReadLeadByUser running...");
		List<Leaderboard> leadList = new ArrayList<Leaderboard>();
		leadList = leaderboard.getLeadByUser("trainerUsername");
		info(leadList.toString());
		assertThat(leadList.isEmpty(), is(false));
	}

	@Test
	public void testFailReadLeadByUser() {
		info("testFailReadLeadByUser running...");
		List<Leaderboard> leadList = new ArrayList<Leaderboard>();
		try {
			leaderboard.setSessionFactory(sf);
			leadList = leaderboard.getLeadByUser("");
			when(sf.openSession()).thenThrow(exceptionSpy);
			assertThat(leadList.isEmpty(), is(true));
		} catch (NullPointerException e) {
			Mockito.verify(exceptionSpy).printStackTrace();
			error("catching" + e + " from testFailReadLeadByUser()");
		}
	}

	@Test
	public void testPassDeleteLeadRecord() {
		info("testPassDeleteLeadRecord running...");
		int leadID = 50;
		assertTrue(leaderboard.deleteLeadByID(leadID));
	}

	@Test
	public void testFailDeleteLeadRecord() {
		info("testFailDeleteLeadRecord running...");
		int leadID = 0;
		try {
			leaderboard.setSessionFactory(sf);
			when(sf.openSession()).thenThrow(exceptionSpy);
			assertFalse(leaderboard.deleteLeadByID(leadID));
		} catch (NullPointerException e) {
			Mockito.verify(exceptionSpy).printStackTrace();
			error("catching" + e + " from testFailDeleteLeadRecord()");
		}
	}
}