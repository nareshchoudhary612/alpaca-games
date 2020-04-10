package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.OrderLine;
import com.tamu.alpacagames.service.GameService;


@Controller
public class AddToCartControllerImpl{
	@Autowired
	GameService gameService;

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ModelAndView addCart(@ModelAttribute("cart") OrderLine cart, Model model) {
		System.out.println("---------------"+cart.getPlatform());
		System.out.println("---------------"+cart.getGameId());
		System.out.println(gameService.getGameById(cart.getGameId()));
		model.addAttribute("game",gameService.getGameById(cart.getGameId()).get());
		return new ModelAndView("html/cart");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView showCart(@ModelAttribute("cart") OrderLine cart, Model model) {
		model.addAttribute("game",gameService.getGameById((long) 1).get());
		return new ModelAndView("html/cart");
	}

}
