package com.marist.sdd.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nikhil
 *
 */

@Controller
public class URLHomeController {

	@RequestMapping(value = "home.urlview")
	public ModelAndView redirectToMain(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("URLHome");
		modelAndView = modelAndView.addObject("message", "Welcome to Poughkeepsie");
		return modelAndView;
	}
	
}
