package org.marist.sdd.projects.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.marist.sdd.projects.pojo.URL;
import org.marist.sdd.projects.pojo.URLHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URLController {
	
	@RequestMapping("redirect.urlview")
	public ModelAndView returnView(){
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	@RequestMapping("addurl.urlview")
	public ModelAndView handleView(@ModelAttribute URLHolder urlHolder){
		List<URL> recentShortUrl = new ArrayList<URL>();
		URL url = new URL(urlHolder.getLongUrl().getUrl() + "?uid="+ urlHolder.getDesiredId(), ".com");
		recentShortUrl.add(url);
		recentShortUrl.add(new URL(urlHolder.getLongUrl().getUrl() + "?uid="+ urlHolder.getDesiredId(), ".com"));
		recentShortUrl.add(new URL(urlHolder.getLongUrl().getUrl() + "?uid="+ urlHolder.getDesiredId(), ".com"));
		ModelAndView mav = new ModelAndView("Home","recentShortUrl",recentShortUrl);
		return mav;
	}

}
