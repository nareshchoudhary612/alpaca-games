package com.tamu.alpacagames.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactUsControllerImpl {
	
	//@GetMapping("/contactus")
	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public ModelAndView getContactPage() {
		return new ModelAndView("html/contact_us");
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public ModelAndView getAboutPage() {
		return new ModelAndView("html/about_us");
	}
}
