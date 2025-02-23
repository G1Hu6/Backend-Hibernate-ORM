package com.orm.criteria;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;




public class CriteriaQueryExample {
	
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		
		s.close();
	}
}
