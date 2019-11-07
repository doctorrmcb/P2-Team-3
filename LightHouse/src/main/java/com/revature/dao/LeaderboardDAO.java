package com.revature.dao;

import java.util.List;

import com.revature.pojo.Leaderboard;

/**
 * This is the interface for LeaderboardDAOImpl
 * It Ensures that CRUD methods are implemented
 * 
 * @author Pameni Gaelle & Roberto Rodriguez
 *
 */
public interface LeaderboardDAO {
	
	/**
	 * Create a Leaderboard into the database based on the object leaderboard
	 * @param lead
	 * @return true if the leaderboard have been created and false otherwise
	 **/
	public boolean createLeaderboard(Leaderboard lead);
	
	/**
	 * Reads all leaderboards from the database
	 * @return a list of all leaderboards
	 */
	public List<Leaderboard> getAllLead();
	
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