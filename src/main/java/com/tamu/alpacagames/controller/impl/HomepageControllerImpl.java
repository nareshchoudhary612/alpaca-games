package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.HomepageController;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.GameService;

@RestController
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
	@GetMapping(value= {"/","index.html"})
	public ModelAndView getFrontGames(Model model) {
		Users user = new Users();
	//	user.setFirstname("test");
		model.addAttribute("games", gameService.getHomepageGames());
		//List<Game> homepageGames = gameService.getHomepageGames();
		model.addAttribute("user",user);
		return new ModelAndView("html/index");
	}	
}