package org.marist.sdd.projects.pojo;

public class URLHolder {
	
	private URL longUrl;
	private URL shortUrl;
	private String desiredId;
	
	public URLHolder(URL longUrl, URL shortUrl,String desiredId) {
		super();
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
		this.desiredId = desiredId;
	}

	public URLHolder() {
	}

	public URL getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(URL longUrl) {
		this.longUrl = longUrl;
	}

	public URL getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(URL shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	public String getDesiredId() {
		return desiredId;
	}

	public void setDesiredId(String desiredId) {
		this.desiredId = desiredId;
	}

	@Override
	public String toString() {
		return "URLHolder [longUrl=" + longUrl + ", shortUrl=" + shortUrl + ", desiredId=" + desiredId + "]";
	}
	
}
