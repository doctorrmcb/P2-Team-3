package com.revature.service;

import java.util.List;

import com.revature.pojo.Leaderboard;

public interface LeaderboardService {
	/**
	 * Create a Leaderboard into the database based on the object leaderboard
	 * @param lead
	 * @return true if the leaderboard have been created and false otherwise
	 **/
	public boolean createLeaderboard(Leaderboard lead);
	
	/**
	 * Read a leaderboard from the database using the category name
	 * @param catName
	 * @return a list of leaderboard if the category 
	 * exists into the database and null otherwise
	 **/
	public List<Leaderboard> getLeadByCat(String catName);
	
	/**
	 * Read a leaderboard from the database using the User name
	 * @param username
	 * @return a list of leaderboard if the username 
	 * exists into the database and null otherwise
	 **/
	public List<Leaderboard> getLeadByUser(String username);
	
	/**
	 * Read a leaderboard from the database using the leadID
	 * @param leadID
	 * @return a leaderboard if the leadID 
	 * exists into the database and null otherwise
	 **/
	public Leaderboard getLeaderboard(int leadID);
	
	/**
	 * Delete a leaderboard from the database using the LeadID
	 * @param LeadID
	 * @return true if the leaderboard was deleted and false otherwise
	 **/
	public boolean deleteLeadByID(int leadID);

}
