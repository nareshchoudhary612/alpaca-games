package com.tamu.alpacagames.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.tamu.alpacagames.model.Game;
import com.tamu.alpacagames.model.OrderLine;
import com.tamu.alpacagames.repository.OrderLineRepository;
import com.tamu.alpacagames.service.GameService;


@Controller
public class AddToCartControllerImpl{
	@Autowired
	GameService gameService;


	@Autowired
	OrderLineRepository orderLineRepository;
	
	@RequestMapping(value = "/cart1", method = RequestMethod.POST)
	public ModelAndView addCart1(@ModelAttribute("cart") OrderLine cart, Model model) {
		
		System.out.println("---------------"+cart.getPlatform());
		System.out.println("---------------"+cart.getGameId());
		System.out.println(gameService.getGameById(cart.getGameId()));
		orderLineRepository.save(cart);
		model.addAttribute("game",gameService.getGameById(cart.getGameId()).get());
		return new ModelAndView("html/cart");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView showCart(@ModelAttribute("mycart") String cart, Model model) {
		List<Game> list = new ArrayList<Game>();
		
		if(cart!=null && cart.length()!=0){
			String[]  gameIds = cart.split(",");
			for(int i=0;i<gameIds.length;i++){
				list.add(gameService.getGameById(Long. parseLong(gameIds[i])).get());
			}
		}
		Gson gson = new Gson();
		model.addAttribute("gameList",list);
		model.addAttribute("gameListString",gson.toJson(list));
		return new ModelAndView("html/cart");
	}
}