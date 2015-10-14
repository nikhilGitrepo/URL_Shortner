package org.marist.sdd.projects.controller;

import java.util.ArrayList;
import java.util.List;

import org.marist.sdd.projects.pojo.URL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import com.cedarsoftware.util.io.JsonWriter;

@Controller
public class AjaxController {
	
	@RequestMapping("getrecent.urlview")
	public @ResponseBody String getRecentUrl(){
		List<String> recentShortUrl = new ArrayList<String>();
		recentShortUrl.add("https://www.youtube.com/watch?v=4fYCp_rjA3A" + "?uid="+ "youtube");
		recentShortUrl.add("https://www.twitter.com/watch?v=4fYCp_rjA3A" + "?uid="+ "twitter");
		recentShortUrl.add("https://www.mindtree.com/watch?v=4fYCp_rjA3A" + "?uid="+ "mindtree");
		recentShortUrl.add("https://www.zoomcar.com/watch?v=4fYCp_rjA3A" + "?uid="+ "zoomcar");
		recentShortUrl.add("https://www.facebook.com/watch?v=4fYCp_rjA3A" + "?uid="+ "facebook");
		recentShortUrl.add("https://www.google.com/watch?v=4fYCp_rjA3A" + "?uid="+ "google");
		recentShortUrl.add("https://www.youtube.com/watch?v=4fYCp_rjA3A" + "?uid="+ "youtube2");
		recentShortUrl.add("https://www.twitter.com/watch?v=4fYCp_rjA3A" + "?uid="+ "twitter2");
		recentShortUrl.add("https://www.mindtree.com/watch?v=4fYCp_rjA3A" + "?uid="+ "mindtree2");
		recentShortUrl.add("https://www.zoomcar.com/watch?v=4fYCp_rjA3A" + "?uid="+ "zoomcar2");
		recentShortUrl.add("https://www.facebook.com/watch?v=4fYCp_rjA3A" + "?uid="+ "facebook2");
		recentShortUrl.add("https://www.google.com/watch?v=4fYCp_rjA3A" + "?uid="+ "google2");
		String jsonList = JsonWriter.objectToJson(recentShortUrl);
		return jsonList;
	}
	
}
