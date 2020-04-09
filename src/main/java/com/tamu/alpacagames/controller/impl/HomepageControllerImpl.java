package com.tamu.alpacagames.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.HomepageController;
import com.tamu.alpacagames.model.Game;
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
	
	
	@Override
	@GetMapping(value={"/"})
	public ModelAndView getFrontGames(Model model) {
		model.addAttribute("games", gameService.getHomepageGames());
		//List<Game> homepageGames = gameService.getHomepageGames();
		return new ModelAndView("/html/index");
	}
	
	

}
