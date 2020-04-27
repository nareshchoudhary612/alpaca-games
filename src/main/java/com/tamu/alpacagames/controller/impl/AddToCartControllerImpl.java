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
import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.OrderLineRepository;
import com.tamu.alpacagames.service.GameService;


@Controller
public class AddToCartControllerImpl{
	@Autowired
	GameService gameService;

	@Autowired
	OrderLineRepository orderLineRepository;
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView showCart(@ModelAttribute("mycart") String cart, Model model) {
		List<Game> list = new ArrayList<Game>();
		
		if(cart!=null && cart.length()!=0){
			String[]  gameIds = cart.split(",");
			for(int i=0;i<gameIds.length;i++){
				list.add(gameService.getGameById(Long. parseLong(gameIds[i])).get());
			}
		}
		
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			name= user.getUsername();
			System.out.println("logged in user---->>"+ name);
		}
		
		Gson gson = new Gson();
		model.addAttribute("gameList",list);
		model.addAttribute("gameListString",gson.toJson(list));
		model.addAttribute("loggedInUser",name);
		return new ModelAndView("html/cart");
	}
}