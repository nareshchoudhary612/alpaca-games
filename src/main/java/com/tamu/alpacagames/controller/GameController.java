package com.tamu.alpacagames.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.Game;

public interface GameController {
	
	 String gameForm(Model model);
	 
	 String gameForm(Game game);

	ModelAndView getGameDetails(String game_id, Model model);
	 
}
