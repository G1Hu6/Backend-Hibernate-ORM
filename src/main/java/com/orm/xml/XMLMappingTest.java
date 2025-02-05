package com.orm.xml;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class XMLMappingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person = new Person(1, "King Tathe", "Pune, NIwase", "1298287334");
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		org.hibernate.Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person);
		System.out.println(session.get(Person.class, 1).getId() + " : " + session.get(Person.class, 1).getName());
		tx.commit();
		session.close();
		factory.close();
	}

}
