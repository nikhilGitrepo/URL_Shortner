package org.marist.sdd.projects.cache;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.marist.sdd.projects.pojo.URL;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;

public class RecentCreatedCacheManager {

	public RecentCreatedCacheManager() {
	}

	@Cacheable("recentCreatedUrl")
	public List<URL> getAccessedUrl() {
		System.out.println("--------------Fetching Data from Database----------------" + new Date() );
		
		List<URL> recentShortUrl = new ArrayList<URL>();
		recentShortUrl.add( new URL("https://www.youtube.com/watch?v=4fYCp_rjA3A" + "?uid="+ "youtube"));
		recentShortUrl.add( new URL("https://www.twitter.com/watch?v=4fYCp_rjA3A" + "?uid="+ "twitter"));
		recentShortUrl.add(new URL("https://www.mindtree.com/watch?v=4fYCp_rjA3A" + "?uid="+ "mindtree"));
		recentShortUrl.add(new URL("https://www.zoomcar.com/watch?v=4fYCp_rjA3A" + "?uid="+ "zoomcar"));
		recentShortUrl.add(new URL("https://www.facebook.com/watch?v=4fYCp_rjA3A" + "?uid="+ "facebook"));
		recentShortUrl.add(new URL("https://www.google.com/watch?v=4fYCp_rjA3A" + "?uid="+ "google"));
		recentShortUrl.add(new URL("https://www.youtube.com/watch?v=4fYCp_rjA3A" + "?uid="+ "youtube2"));
		recentShortUrl.add(new URL("https://www.twitter.com/watch?v=4fYCp_rjA3A" + "?uid="+ "twitter2"));
		recentShortUrl.add(new URL("https://www.mindtree.com/watch?v=4fYCp_rjA3A" + "?uid="+ "mindtree2"));
		recentShortUrl.add(new URL("https://www.zoomcar.com/watch?v=4fYCp_rjA3A" + "?uid="+ "zoomcar2"));
		recentShortUrl.add(new URL("https://www.facebook.com/watch?v=4fYCp_rjA3A" + "?uid="+ "facebook2"));
		recentShortUrl.add(new URL("https://www.google.com/watch?v=4fYCp_rjA3A" + "?uid="+ "google2"));
		return recentShortUrl;
	}

}
