package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tamu.alpacagames.controller.GameController;
import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.service.GameService;

@Controller
public class GameControllerImpl implements GameController {
	
	@Autowired
	GameService gameService;
	
	@Override
	@GetMapping("/newgame")
	public String gameForm(Model model) {
		model.addAttribute("game", new Game());
		return "game-form";
	}

	@Override
	@PostMapping("/newgame")
	public String gameForm(@ModelAttribute Game game) {
		
		game = gameService.createGame(game);
		// TODO Auto-generated method stub
		return "game-save-result";
	}
	
	@Override
	@GetMapping("/game/{id}")
	public String getGameDetails( @PathVariable String id, Model model) {
		System.out.println(id);
		model.addAttribute(gameService.getGameById(Long.parseLong(id)));
		
		return "html/product-details";
	}



}
