package com.tamu.alpacagames.controller;

import org.springframework.ui.Model;

import com.tamu.alpacagames.model.Game;

public interface GameController {
	
	 String gameForm(Model model);
	 
	 String gameForm(Game game);

	String getGameDetails(String game_id, Model model);
	 
	
	 
}
