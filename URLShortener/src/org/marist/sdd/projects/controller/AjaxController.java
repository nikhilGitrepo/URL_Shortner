package org.marist.sdd.projects.controller;

import java.util.ArrayList;
import java.util.List;

import org.marist.sdd.projects.cache.RecentCreatedCacheManager;
import org.marist.sdd.projects.pojo.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cedarsoftware.util.io.JsonWriter;

@Controller
public class AjaxController {
	
	RecentCreatedCacheManager manager;

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	private String jsonList;
	
	@RequestMapping("getrecent.ajax")
	public @ResponseBody String getRecentUrl(){

		List<URL> recentShortUrl = new ArrayList<URL>();
		
		if (ctx.isActive()) {
			if (ctx.containsBean("getRecentAccessedCacheManager")) {
				manager = ctx.getBean(RecentCreatedCacheManager.class);
			}
		}
		recentShortUrl = manager.getAccessedUrl();
		
		jsonList = JsonWriter.objectToJson(recentShortUrl);
		return jsonList;
	}
	
}
