package org.marist.sdd.projects.transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.marist.sdd.projects.model.URLMap;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.util.HibernateUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("TransactionDao")
public class TransactionManager extends HibernateUtil implements TransactionManagerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getRecentUrl() {
		Session session = getSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(URLDuo.class);
		cr.setProjection(Projections.property("shortUrl"));
		cr.addOrder((Order.desc("dateCreated")));
		cr.setMaxResults(10);
		
		List<String> urls = cr.list();
		
		return urls;
	}

	@Override
	public boolean addUrl(URLDuo url) {

		try {
			Session session = getSession();
			session.beginTransaction();

			session.saveOrUpdate(url);
			
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<URLDuo> loadAllUrl() {
		List<URLDuo> allUrl = new ArrayList<URLDuo>();
		
		try {
			Session session = getSession();
			session.getTransaction().begin();

			Query query = session.getNamedQuery("findAllUrlsINDatabase");
			allUrl = (List<URLDuo>) query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allUrl;
	}
	
}
