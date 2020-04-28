package com.tamu.alpacagames.controller.impl;

import java.util.Date;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import com.tamu.alpacagames.model.OrderLine;
import com.tamu.alpacagames.model.Orders;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.OrderLineRepository;
import com.tamu.alpacagames.repository.OrdersRepository;
import com.tamu.alpacagames.service.GameService;


@Controller
public class AddToCartControllerImpl{
	@Autowired
	GameService gameService;

	@Autowired
	OrderLineRepository orderLineRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
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
		long orderId = 0;
		if(user==null){
			System.out.println("No User");
		}else{
			name= user.getUsername();
			System.out.println("logged in user---->>"+ name);
			//add to order and orderline
			if(list.size()>0){
				orderId = addToOrderLine(list,name);
			}
		}
		
		Gson gson = new Gson();
		model.addAttribute("gameList",list);
		model.addAttribute("gameListString",gson.toJson(list));
		model.addAttribute("loggedInUser",name);
		model.addAttribute("orderIdGenerated",orderId);
		return new ModelAndView("html/cart");
	}

	private Long addToOrderLine(List<Game> list, String name) {
		double billAmount = 0;
				
		java.util.Date today=new Date();
		java.sql.Date date=new java.sql.Date(today.getTime());
		
		for(Game game: list){
			double price = game.getDiscount();
			billAmount=+price;
		}
		Orders val = new Orders();
		val.setDate(date);		
		double finVal = (billAmount+6.94);
		BigDecimal bd = new BigDecimal(finVal).setScale(2, RoundingMode.HALF_UP);
        double newInput = bd.doubleValue();
		val.setBillAmount(newInput);
		val.setDeliveryStatus(false);		
		val.setUserId(name);
		Orders savedOrder= ordersRepository.save(val);
		
		for(Game game: list){
			OrderLine ol = new OrderLine();
			ol.setGameId(game.getGameId());
			ol.setFinalPrice(game.getDiscount());
			ol.setOrderId(savedOrder.getOrderId());
			ol.setPlatform("PS");
			orderLineRepository.save(ol);
		}
				
		System.out.println("*---------cart saved-----------*");
		return savedOrder.getOrderId();
	}
	
	
	
}