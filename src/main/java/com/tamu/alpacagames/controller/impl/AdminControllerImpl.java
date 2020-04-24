package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.UserController;
import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.GameService;
import com.tamu.alpacagames.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminControllerImpl {

	@Autowired
	UserService userService;

	@Autowired
	GameService gameService;

	@GetMapping(value= {"/","adminHomepage.html"}) 
	public String getAdminHomePage() {
		return "html/adminHomepage.html";
	}

	/*************************************************************
	 * 						Games CRUD /
	 *************************************************************/

	@GetMapping("/games")
	public ModelAndView getAllGames(Model model) {
		model.addAttribute("games", gameService.getGames());
		return new ModelAndView("html/viewGames.html");
	}

	@GetMapping("/game/new")
	public String gameForm(Model model) {
		model.addAttribute("game", new Game());
		return "html/game-form";
	}

	@PostMapping("/game/new")
	public String gameForm(@ModelAttribute Game game) {

		if (game.getGameId() == null) {
			game = gameService.createGame(game);
			// TODO Auto-generated method stub
			System.out.println("here");
		} else {
			gameService.save(game);
		}

		return "redirect:/admin/games";
	}

	/*
	 * @PostMapping("game/{id}") String editGamd(@PathVariable Long id) {
	 * System.out.println("in post");
	 * 
	 * return "redirect:/admin/games"; }
	 */

	@PostMapping("/game/delete/{id}")
	String deleteGame(@PathVariable Long id) {
		gameService.deleteById(id);

		return "redirect:/admin/games";
	}

	@GetMapping("/game/edit/{id}")
	String editGame(@PathVariable Long id, Model model) {

		model.addAttribute("game", gameService.getGameById(id).get());
		return "html/game-edit-form";
	}

	@PostMapping("/game/edit/{id}")
	String editGame(@PathVariable Long id, @ModelAttribute Game game) {

		System.out.println(game.getGameId());
		game.setGameId(id);
		gameService.save(game);
		return "redirect:/admin/games";
	}
	

	/*************************************************************
	 * 					Users CRUD /
	 *************************************************************/
		
	@GetMapping("/users")
	public ModelAndView getAllUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return new ModelAndView("html/viewUsers.html");
	}
	
	@PostMapping("/user/delete/{id}")
	String deleteUser(@PathVariable Long id) {
		userService.deleteById(id);

		return "redirect:/admin/users";
	}
	
	/*************************************************************
	 * 					Orders CRUD /
	 *************************************************************/
}
