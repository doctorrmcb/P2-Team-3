package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Leaderboard;
import com.revature.service.LeaderboardServiceImpl;

/**
 * Controller for all leaderboards
 * @author Robert Li
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true" /*"*"*/)
public class LeaderboardController {
	
	private LeaderboardServiceImpl lboardService;

	@Autowired
	public void setLboardService(LeaderboardServiceImpl lboardService) {
		this.lboardService = lboardService;
	}
	
	/**
	 * Gets a list of all leaderboards
	 * @return list of leaderboards
	 */
	@GetMapping("/leaderboard")
	public List<Leaderboard> getLeaderboards(){
		return lboardService.getAllLead();
	}

}
