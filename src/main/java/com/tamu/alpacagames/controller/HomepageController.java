package com.tamu.alpacagames.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.Game;

public interface HomepageController {
	
	//List<Game> getFrontGames();
	ModelAndView getFrontGames(Model model);
}
