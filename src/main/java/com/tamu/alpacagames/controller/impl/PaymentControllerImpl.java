package com.tamu.alpacagames.controller.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Orders;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.OrdersRepository;
import com.tamu.alpacagames.service.impl.OrderHistoryImpl;

@Controller
public class PaymentControllerImpl {
	
	@Autowired
	OrdersRepository ordersRepository;

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ModelAndView getPaymentPage(Model model) {
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			name= user.getUsername();
			System.out.println("logged in user---->>"+ name);
		}
		model.addAttribute("user",name);
		return new ModelAndView("html/payment");
	}
	

	@RequestMapping(value = "/paymentComplete", method = RequestMethod.POST)
	public ModelAndView completePaymentPage(@ModelAttribute("orderId") String orderId, Model model) {
	
		System.out.println("Order ID-------->"+orderId);
		ModelAndView mav = new ModelAndView("html/paymentCompleted");
		
		Optional<Orders> orders = ordersRepository.findById(Long.parseLong(orderId));
		Orders order = orders.get();
		order.setDeliveryStatus(true);
		ordersRepository.save(order);
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			name= user.getUsername();
			System.out.println("logged in user---->>"+ name);
		}		
		
		mav.addObject("user",name);
		mav.addObject("orderID", orderId);
		model.addAttribute("user",name);
		model.addAttribute("orderID",orderId);
		return mav;
		
	}
	

		
}
