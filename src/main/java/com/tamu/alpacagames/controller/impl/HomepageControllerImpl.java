package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.HomepageController;
import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.GameService;

@RestController
public class HomepageControllerImpl implements HomepageController {
	
	@Autowired
	GameService gameService;
	
		
	@Override
	@GetMapping(value= {"/","index.html"})
	public ModelAndView getFrontGames(Model model) {
		model.addAttribute("games", gameService.getHomepageGames());
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			System.out.println("logged in user---->>"+ user.getUsername());
			name= user.getUsername();
		}
		
		model.addAttribute("user",name);
		return new ModelAndView("html/index");
	}	
}