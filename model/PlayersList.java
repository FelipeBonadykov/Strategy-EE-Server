package com.bonadykov.serverstrategy.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component("playerList")
public class PlayersList {
	private ArrayList<Player> players = new ArrayList<>();
	
	public long addPlayerAndGetItsNumber(Player player) {
		players.add(player);
		return players.size()-1;
	}
	
	public Player getPlayerByNumber(int number) {
		return players.get(number);
	}

	@RequestMapping("/qwerty")
	public void removeAllElementsFromList() {
		players.clear();
	}
}
