package com.bonadykov.serverstrategy.logic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonadykov.serverstrategy.model.Player;
import com.bonadykov.serverstrategy.model.PlayersList;

@RestController
@Component
public class NewPlayerRegisterer {
	/**
	 * This class adds new Player to the list of players 
	 * and returns the number that will be used to get opponent credentials
	 * @param request
	 * @return
	 */
	@Autowired
	PlayersList playerList;
	
	@GetMapping("/init")
	public long addPlayerToListOfPlayers(HttpServletRequest request) {
		Player player = new Player(request.getRemoteAddr(), 8080);
		return playerList.addPlayerAndGetItsNumber(player);
	}

}
