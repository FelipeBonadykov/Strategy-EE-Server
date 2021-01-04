package com.bonadykov.serverstrategy.logic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonadykov.serverstrategy.model.NoOpponent;
import com.bonadykov.serverstrategy.model.Player;
import com.bonadykov.serverstrategy.model.PlayersList;

@RestController
@Component
public class PlayerConnector {
	/**
	 * This class receives player's number in parameter
	 * then gives a NoPlayer if there is no opponent waiting for us
	 * and ip if there is an opponent
	 * @param request
	 * @return
	 */
	@Autowired
	PlayersList playerList;
	
	@GetMapping("/connect")
	public Player getIndexOfOpponent(HttpServletRequest request) {
		int number = Integer.parseInt(request.getParameter("number"));
		if (number%2 == 1) {
			return playerList.getPlayerByNumber(number-1);
		} else {
			try {
				return playerList.getPlayerByNumber(number+1);
			} catch (Exception e) {
				return new NoOpponent();
			}
		}
	}

}
