package org.mini.sdd.projects.transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mini.sdd.projects.pojo.URLDuo;
import org.mini.sdd.projects.util.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository("TransactionDao")
public class TransactionManager extends HibernateUtil implements TransactionManagerDao {

	public TransactionManager() {
	}

	@Override
	public String getActualUrl(String desiredId) {

		String actualUrl = "";
		Session session = getSession();
		session.getTransaction().begin();
		
		String hql = "select longUrl from URLDuo where desiredId = '"+desiredId+"'";
		List result = session.createQuery(hql).list();
		actualUrl = (String) result.get(0); 
		
		return actualUrl;
	}
	
}
