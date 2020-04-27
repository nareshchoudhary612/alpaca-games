package com.tamu.alpacagames.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tamu.alpacagames.model.LoggedInUser;
import com.tamu.alpacagames.model.Message;
import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.MessageRepository;

@Controller
public class ContactUsControllerImpl {
	
	@Autowired
	MessageRepository messageRepository;
	
	
	//@GetMapping("/contactus")
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView getContactPage(Model model) {
		
		ModelAndView mav = new ModelAndView("html/contact_us");
		mav.addObject("message", new Message());
		mav.addObject("success", "");
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			System.out.println("logged in user---->>"+ user.getUsername());
			name= user.getUsername();
		}
		
		model.addAttribute("user",name);
		
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
		
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			System.out.println("logged in user---->>"+ user.getUsername());
			name= user.getUsername();
		}
		
		model.addAttribute("user",name);
		model.addAttribute("success", "Thank you for contacting us.We will get in touch with you soon. Have a great day!");
		return mav;
		
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView getAboutPage(Model model) {
		Users user = LoggedInUser.getUser();
		String name = null;
		if(user==null){
			System.out.println("No User");
		}else{
			System.out.println("logged in user---->>"+ user.getUsername());
			name= user.getUsername();
		}
		
		model.addAttribute("user",name);
		return new ModelAndView("html/about_us");
	}
	
	
}
