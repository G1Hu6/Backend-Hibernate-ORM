package com.orm.embeddable.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableTestApp {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Creating an instance Company class 
		Company comp1 = new Company();
		// Creating an instance Technology class 
		Technology tech = new Technology();
		tech.setName("Java");
		tech.setFramework("Spring Framework");
		
		comp1.setId(101);
		comp1.setName("VmWare");
		comp1.setTech(tech);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//session.save(comp1);
		   /*
		    * save(Object) method is Deprecated since Spring 6.0 so use persist(Object)
		    * This operation is very similar to persist(Object).
		    */
		session.persist(comp1);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
