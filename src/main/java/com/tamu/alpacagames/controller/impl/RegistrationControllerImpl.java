package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.RegistrationController;
import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.UserService;

@Controller
public class RegistrationControllerImpl implements RegistrationController {
	
	@Autowired
	UserService userService;
	
	/*
	 * @Override
	 * 
	 * @GetMapping("/register") public String showRegister(Model model) {
	 * model.addAttribute("user", new User()); return "html/register"; }
	 */
	
	@Override
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		 ModelAndView mav = new ModelAndView("html/register");
		    mav.addObject("user", new Users());
		    return mav;
	}

	@Override
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") Users user) {
		Users createdUser = userService.createUser(user);
		  return new ModelAndView("html/welcome", "firstname", createdUser.getFirstname());
	}

}
