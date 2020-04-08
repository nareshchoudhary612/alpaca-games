package com.tamu.alpacagames.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.Users;

public interface RegistrationController {
	
	public ModelAndView showRegister();
	
	public ModelAndView addUser( Users user);

//	public String showRegister(Model model);
	
}
