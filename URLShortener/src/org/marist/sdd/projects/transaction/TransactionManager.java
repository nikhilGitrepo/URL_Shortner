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

	public TransactionManager() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getRecentUrl() {
		Session session = getSession();
		session.getTransaction().begin();
		Criteria cr = session.createCriteria(URLDuo.class);
		cr.setProjection(Projections.property("shortUrl"));
		cr.addOrder((Order.desc("dateCreated")));
		cr.setMaxResults(10);
		
		List<String> urls = cr.list();

		return urls;
	}

	@Override
	public boolean addUrl(URLDuo url) {

		Session session = getSession();
		try {
			session.getTransaction().begin();

			session.saveOrUpdate(url);
			
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<URLDuo> loadAllUrl() {
		List<URLDuo> allUrl = new ArrayList<URLDuo>();
		
		Session session = getSession();
		try {
			session.getTransaction().begin();

			Query query = session.getNamedQuery("findAllUrlsINDatabase");
			allUrl = (List<URLDuo>) query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUrl;
	}

	@Override
	public List<String> loadAllDesiredId() {
		List<String> allDesiredId = new ArrayList<String>();
		Session session = getSession();
		session.getTransaction().begin();
		Criteria cr = session.createCriteria(URLDuo.class);
		cr.setProjection(Projections.property("desiredId"));
		
		allDesiredId = cr.list();
		return allDesiredId;
	}
	
}
