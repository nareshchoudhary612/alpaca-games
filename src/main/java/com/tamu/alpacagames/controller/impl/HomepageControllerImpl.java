package com.tamu.alpacagames.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.HomepageController;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.GameService;

@Controller
public class HomepageControllerImpl implements HomepageController {
	
	@Autowired
	GameService gameService;
	
	/*
	 * @Override
	 * 
	 * @GetMapping("/") public List<Game> getFrontGames() { List<Game>
	 * homepageGames = gameService.getHomepageGames(); return homepageGames; }
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getFrontGames() {
		//model.addAttribute("games", gameService.getHomepageGames());
		//List<Game> homepageGames = gameService.getHomepageGames();
		return new ModelAndView("html/index");
	}

	@Override
	public ModelAndView getFrontGames(Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
