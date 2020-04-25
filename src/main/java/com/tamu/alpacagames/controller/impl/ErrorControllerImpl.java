package com.tamu.alpacagames.controller.impl;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorControllerImpl implements ErrorController{
	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public ModelAndView error() {
		return new ModelAndView("html/error");
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
