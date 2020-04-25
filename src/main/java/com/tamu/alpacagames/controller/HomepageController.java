package com.tamu.alpacagames.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface HomepageController {
	ModelAndView getFrontGames(Model model);
}
