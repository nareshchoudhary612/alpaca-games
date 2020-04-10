package com.tamu.alpacagames.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.OrderLine;

@Controller
public class AddToCartImpl{

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("cart") OrderLine cart) {
		System.out.println();
		return new ModelAndView("html/cart");
	}

}
