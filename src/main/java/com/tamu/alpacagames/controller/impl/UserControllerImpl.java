package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.controller.UserController;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.UserService;

@Controller
public class UserControllerImpl extends UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView("html/login");
		mav.addObject("user", new Users());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("user") Users user) {
		ModelAndView mav = null;
		boolean loginFlag = userService.validateUser(user);
		if (loginFlag) {
			mav = new ModelAndView("html/index.html");
			//mav.addObject("username", user.getUsername());
		} else {
			mav = new ModelAndView("html/login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

}
