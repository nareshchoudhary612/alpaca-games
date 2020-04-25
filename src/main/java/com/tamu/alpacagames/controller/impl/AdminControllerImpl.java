package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.GameRepository;
import com.tamu.alpacagames.service.GameService;
import com.tamu.alpacagames.service.UserService;
import com.tamu.alpacagames.service.impl.OrderHistoryImpl;

@Controller
@RequestMapping("/admin")
public class AdminControllerImpl {

	@Autowired
	UserService userService;

	@Autowired
	GameService gameService;

	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	OrderHistoryImpl orderService;
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("user") Users user, Model model) {
		ModelAndView mav = null;
		//boolean loginFlag = userService.validateUser(user);
		if (user.getUsername().contentEquals("admin") && user.getPassword().equals("admin")) {
			model.addAttribute("user",user);
			mav = new ModelAndView("redirect:adminHomepage.html");

			//mav.addObject("username", user.getUsername());
		} else {
			mav = new ModelAndView("html/login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@GetMapping(value= {"","adminHomepage.html"}) 
	public String getAdminHomePage() {
		return "html/adminHomepage.html";
	}

	/*************************************************************
	 * 						Games CRUD /
	 *************************************************************/

	@GetMapping("/games")
	public ModelAndView getAllGames(Model model) {
		//model.addAttribute("games", gameService.getGames());
		model.addAttribute("games", gameRepository.findAll(Sort.by(Sort.Direction.ASC, "gameId")));
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
	@GetMapping("/orders")
	public ModelAndView getAllOrders(Model model) {
		model.addAttribute("orders", orderService.getOrders());
		return new ModelAndView("html/viewOrders.html");
	}
}
