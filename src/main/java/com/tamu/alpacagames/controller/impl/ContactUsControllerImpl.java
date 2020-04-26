package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.Message;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.MessageRepository;

@Controller
public class ContactUsControllerImpl {
	
	@Autowired
	MessageRepository messageRepository;
	
	
	//@GetMapping("/contactus")
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView getContactPage() {
		
		ModelAndView mav = new ModelAndView("html/contact_us");
		mav.addObject("message", new Message());
		mav.addObject("success", "");
		return mav;
		
	}
	
	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public ModelAndView getContactPage(@ModelAttribute("message") Message msg, Model model) {
		System.out.println("saved message");
		System.out.println("this is the message: " +msg.getMsg());
		System.out.println("and this is the id: "+ msg.getMessageId());
		messageRepository.save(msg);
		
		ModelAndView mav = new ModelAndView("html/contact_us");
		mav.addObject("message", new Message());
		mav.addObject("success", "Thank you for your feedback. If required, we will get back to you");
		return mav;
		
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView getAboutPage() {
		return new ModelAndView("html/about_us");
	}
	
	
}
