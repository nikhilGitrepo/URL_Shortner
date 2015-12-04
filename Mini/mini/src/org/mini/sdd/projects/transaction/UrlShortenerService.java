package org.mini.sdd.projects.transaction;

import javax.transaction.Transactional;

import org.mini.sdd.projects.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("urlShortenerService")
@Transactional
public class UrlShortenerService extends HibernateUtil  implements UrlShortenerServiceDao{

	@Autowired
	TransactionManagerDao transactionDao;

	@Override
	public String getActualUrl(String desiredId) {
		return transactionDao.getActualUrl(desiredId);
	}
	
}
