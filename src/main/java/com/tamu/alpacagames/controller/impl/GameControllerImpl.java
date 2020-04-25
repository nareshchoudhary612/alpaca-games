package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.GameController;
import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.model.OrderLine;
import com.tamu.alpacagames.service.GameService;

@Controller
public class GameControllerImpl implements GameController {
	
	@Autowired
	GameService gameService;
	
	
	@GetMapping("/games")
	public String gamePage(Model model) {
		model.addAttribute("games", gameService.getGames());
		return "html/Games";
	}
	
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
	public ModelAndView getGameDetails( @PathVariable String id, Model model) {
		System.out.println(id);
		model.addAttribute("game",gameService.getGameById(Long.parseLong(id)).get());
		System.out.println(gameService.getGameById(Long.parseLong(id)).get().getImageUrl1());
		model.addAttribute("cart", new OrderLine());
		System.out.println(gameService.getGameById(Long.parseLong(id)));
		return new ModelAndView("html/product-details");
	}
}