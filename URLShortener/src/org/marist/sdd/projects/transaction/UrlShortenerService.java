package org.marist.sdd.projects.transaction;

import java.util.List;

import javax.transaction.Transactional;

import org.marist.sdd.projects.constants.ApplicationConstants;
import org.marist.sdd.projects.model.ShortUrl;
import org.marist.sdd.projects.pojo.URL;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.pojo.URLHolder;
import org.marist.sdd.projects.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("urlShortenerService")
@Transactional
@PropertySource(value = { "classpath:application.properties" })
public class UrlShortenerService extends HibernateUtil  implements UrlShortenerServiceDao{

	@Autowired
	TransactionManagerDao transactionDao;
	
    @Autowired
    private Environment environment;
	
	@Override
	public List<String> getRecentUrl() {
		return transactionDao.getRecentUrl();
	}

	@Override
	public ShortUrl addUrl(URLHolder urlholder) {
		
		URLDuo url = new URLDuo(urlholder.getLongUrl().getUrl(), 
									urlholder.getDesiredId(),
									environment.getRequiredProperty(ApplicationConstants.APPLICATION_DOMAIN_NAME.value)
										 + urlholder.getDesiredId());

		boolean result = transactionDao.addUrl(url);
		ShortUrl shortUrl = new ShortUrl();
		if(result){
			shortUrl.setMessage(environment.getRequiredProperty(ApplicationConstants.SUCCESS_URL_CREATION.value));
			shortUrl.setShortUrl(new URL( url.getShortUrl() ));
		}else{
			shortUrl.setMessage(environment.getRequiredProperty(ApplicationConstants.ERROR_URL_CREATION.value));
		}
		shortUrl.setError(result);
		return shortUrl;
	}
	
}
