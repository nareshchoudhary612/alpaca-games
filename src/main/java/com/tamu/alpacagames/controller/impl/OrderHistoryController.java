package com.tamu.alpacagames.controller.impl;

import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderHistoryController {

	@Autowired
	OrderService orderService;

    @RequestMapping(value = "/orderhistory/{id}", method = RequestMethod.GET)
	public ModelAndView getOrderHistoryPage(@PathVariable String id,Model model) {

		System.out.println(orderService.GetOrdersByUserId("1").get(0).getBillAmount());
		model.addAttribute("orders", orderService.GetOrdersByUserId(id));
		
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			System.out.println("logged in user---->>"+ user.getUsername());
			name= user.getUsername();
		}
		
		model.addAttribute("user",name);
		
		return new ModelAndView("html/order_history");
	}
}
