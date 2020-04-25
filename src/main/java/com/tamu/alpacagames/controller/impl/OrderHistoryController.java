package com.tamu.alpacagames.controller.impl;

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
		return new ModelAndView("html/order_history");
	}
}
