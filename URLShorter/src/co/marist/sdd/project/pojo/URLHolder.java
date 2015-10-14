package co.marist.sdd.project.pojo;

public class URLHolder {
	
	private URL longUrl;
	private URL shortUrl;
	
	public URLHolder(URL longUrl, URL shortUrl) {
		super();
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((longUrl == null) ? 0 : longUrl.hashCode());
		result = prime * result + ((shortUrl == null) ? 0 : shortUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URLHolder other = (URLHolder) obj;
		if (longUrl == null) {
			if (other.longUrl != null)
				return false;
		} else if (!longUrl.equals(other.longUrl))
			return false;
		if (shortUrl == null) {
			if (other.shortUrl != null)
				return false;
		} else if (!shortUrl.equals(other.shortUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "URLHolder [longUrl=" + longUrl + ", shortUrl=" + shortUrl + "]";
	}
	
}
