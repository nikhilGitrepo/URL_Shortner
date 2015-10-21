package org.marist.sdd.projects.pojo;

import java.util.ArrayList;
import java.util.List;

public class RecentCreatedUrl {
	
	public RecentCreatedUrl() {
		super();
	}

	private List<URL> recentCreatedUrls = new ArrayList<>();

	public RecentCreatedUrl(List<URL> recentCreatedUrls) {
		this.recentCreatedUrls = recentCreatedUrls;
	}

	public List<URL> getRecentCreatedUrls() {
		return recentCreatedUrls;
	}

	public void setRecentCreatedUrls(List<URL> recentCreatedUrls) {
		this.recentCreatedUrls = recentCreatedUrls;
	}
	
}
