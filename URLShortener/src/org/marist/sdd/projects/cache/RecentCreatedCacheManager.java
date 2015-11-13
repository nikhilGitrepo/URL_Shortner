package org.marist.sdd.projects.cache;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.marist.sdd.projects.pojo.URL;
import org.marist.sdd.projects.transaction.UrlShortenerServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

public class RecentCreatedCacheManager {

	@Autowired
	UrlShortenerServiceDao urlDao;
	
	public RecentCreatedCacheManager() {
	}

	@Cacheable("serverEhCache")
	public List<URL> getAccessedUrl() {
		List<String> list = urlDao.getRecentUrl();
		
		List<URL> recentShortUrl = new ArrayList<URL>();
		for(String urlString : list){
			recentShortUrl.add(new URL(urlString));
		}
				
		return recentShortUrl;
	}

}
