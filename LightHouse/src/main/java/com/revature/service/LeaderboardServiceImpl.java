package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.LeaderboardDAO;
import com.revature.pojo.Leaderboard;
import static com.revature.util.LoggerUtil.*;
@Component
public class LeaderboardServiceImpl implements LeaderboardService {

	private static LeaderboardDAO leadDAO;
	
	@Autowired
	public void setLeaderboardDAO(LeaderboardDAO leadDAO) {
		this.leadDAO = leadDAO;
	}
	@Override
	public boolean createLeaderboard(Leaderboard lead) {
		// TODO Auto-generated method stub
		debug("Checking to see if for some reason they have the same id");
		Leaderboard newL = leadDAO.getLeaderboard(lead.getLeadID());
		if(newL != null) {
			return false;
		}else {
			leadDAO.createLeaderboard(lead);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Leaderboard> getLeadByCat(String catName) {
		// TODO Auto-generated method stub
		return leadDAO.getLeadByCat(catName);
	}

	@Override
	public List<Leaderboard> getLeadByUser(String username) {
		// TODO Auto-generated method stub
		return leadDAO.getLeadByUser(username);
	}

	@Override
	public Leaderboard getLeaderboard(int leadID) {
		Leaderboard lead = leadDAO.getLeaderboard(leadID);
		if(lead == null) {
			return null;
		}else {
			return lead;
		}
	}

	@Override
	public boolean deleteLeadByID(int leadID) {
		
		Leaderboard lead = leadDAO.getLeaderboard(leadID);
		if(lead == null) {
		return false;
		}else {
			leadDAO.deleteLeadByID(leadID);
			return true;
		}
	}

}
