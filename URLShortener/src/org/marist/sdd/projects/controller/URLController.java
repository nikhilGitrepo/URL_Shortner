package org.marist.sdd.projects.controller;

import org.marist.sdd.projects.configuration.ChacheConfig;
import org.marist.sdd.projects.pojo.URLHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.ehcache.CacheManager;

@Controller
public class URLController {
	

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	@RequestMapping("redirect.urlview")
	public ModelAndView returnView(){
		ModelAndView mav = new ModelAndView("Home");
		
		if(!ctx.isActive()){
			
			if(!ctx.containsBean("getRecentAccessedCacheManager")){
				ctx.register(ChacheConfig.class);
				ctx.refresh();
			}else if(!ctx.isActive()){
				ctx.refresh();
			}
		}
		
		return mav;
	}
	
	@RequestMapping("addurl.urlview")
	public ModelAndView handleView(@ModelAttribute URLHolder urlHolder){
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}

}
