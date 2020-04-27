package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.UserController;
import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.GameService;
import com.tamu.alpacagames.service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;

	@Autowired
	GameService gameService;

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(Model model) {
		ModelAndView mav = new ModelAndView("html/login");
		mav.addObject("message", "");
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			System.out.println("logged in user---->>"+ user.getUsername());
			name= user.getUsername();
		}
		
		model.addAttribute("loggedInUser",name);
		mav.addObject("user", new Users());
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView showLogout() {
		ModelAndView mav = new ModelAndView("html/index");
		LoggedInUser.setUser(new Users());
		mav.addObject("user", null);
		mav.addObject("games", gameService.getHomepageGames());
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage(Model model) {
		model.addAttribute("games", gameService.getHomepageGames());
		//List<Game> homepageGames = gameService.getHomepageGames();
		return new ModelAndView("html/home");
	}

	@Override
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("user") Users user, Model model) {
		ModelAndView mav = null;
		boolean loginFlag = userService.validateUser(user);
		System.out.println("Login process"+ loginFlag);
		if (loginFlag) {
			System.out.println("Login successful!");
			LoggedInUser.setUser(user);
			String name = user==null?"":user.getUsername();
			System.out.println("name------>"+name);
			model.addAttribute("user",name);
			mav = new ModelAndView("redirect:index.html");

			//mav.addObject("username", user.getUsername());
		} else {
			
			System.out.println("Login failed!");
			mav = new ModelAndView("html/login");
			mav.addObject("message", "Username or Password is wrong!! Please try again");
		}
		return mav;
	}
}
