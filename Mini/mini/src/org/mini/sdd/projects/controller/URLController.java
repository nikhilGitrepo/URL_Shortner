package org.mini.sdd.projects.controller;

import javax.servlet.http.HttpServletRequest;

import org.mini.sdd.projects.configuration.AppConfig;
import org.mini.sdd.projects.transaction.UrlShortenerServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URLController {

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	@Autowired
	UrlShortenerServiceDao urlDao;
	
	@RequestMapping("/")
	public ModelAndView redirectToActual(HttpServletRequest req){
		if(!ctx.isActive()){
			ctx.register(AppConfig.class);
			ctx.refresh();
		}
		String url = urlDao.getActualUrl(req.getQueryString());
		
		ModelAndView mav = new ModelAndView("redirect:" + url);
		return mav;
		
		
	}

}
