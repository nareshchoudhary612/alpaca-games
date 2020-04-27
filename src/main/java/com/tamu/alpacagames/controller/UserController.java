package com.tamu.alpacagames.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.Users;

public interface UserController {
	public ModelAndView showLogin(Model model) ;
	public ModelAndView loginProcess(Users user, Model model);
}
