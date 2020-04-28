package com.tamu.alpacagames.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Users;

@Controller
public class PaymentControllerImpl {

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
	public ModelAndView completePaymentPage(Model model) {
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
}
