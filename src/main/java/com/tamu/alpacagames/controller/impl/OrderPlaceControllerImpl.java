package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.OrderLine;
import com.tamu.alpacagames.repository.OrderLineRepository;
import com.tamu.alpacagames.service.GameService;

@Controller
public class OrderPlaceControllerImpl {
	
	@Autowired
	GameService gameService;


	@Autowired
	OrderLineRepository orderLineRepository;

	@RequestMapping(value = "/ca", method = RequestMethod.POST)
	public ModelAndView addCart1(@ModelAttribute("cart") OrderLine cart, Model model) {
		
		orderLineRepository.save(cart);
		model.addAttribute("game",gameService.getGameById(cart.getGameId()).get());
		return new ModelAndView("html/cart");
	}
}
