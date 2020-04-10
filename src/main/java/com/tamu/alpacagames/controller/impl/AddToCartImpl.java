package com.tamu.alpacagames.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.OrderLine;

@Controller
public class AddToCartImpl{

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ModelAndView addCart(@ModelAttribute("cart") OrderLine cart) {
		System.out.println("---------------"+cart.getPlatform());
		return new ModelAndView("html/cart");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView showCart(@ModelAttribute("cart") OrderLine cart) {
		return new ModelAndView("html/cart");
	}

}
