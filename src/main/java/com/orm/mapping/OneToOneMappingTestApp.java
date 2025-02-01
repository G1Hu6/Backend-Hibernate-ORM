package com.orm.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingTestApp {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure(StandardServiceRegistryBuilder.DEFAULT_CFG_RESOURCE_NAME);
		SessionFactory factory = cfg.buildSessionFactory();

		// creating instance of Question class
		Question que1 = new Question();
		que1.setQuestionId(6);
		que1.setQuestion("Who am I ?");
		

		// creating instance of Answer class
		Answer ans1 = new Answer();
		ans1.setAnswerId(106);
		ans1.setAnswer("Mew");
		ans1.setQue(que1);
		//que1.setAnswer(ans1);

		
		/*
		// creating instance of Question class
		Question que2 = new Question();
		que2.setQuestionId(4);
		que2.setQuestion("Who is the creater of CPP ?");

		// creating instance of Answer class
		Answer ans2 = new Answer();
		ans2.setAnswerId(104);
		ans2.setAnswer("Bjarne Stroustrup");
		que2.setAnswer(ans2);
        */
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
        
		
		session.persist(que1);
		session.persist(ans1);
		//session.persist(ans1);
		//session.persist(ans2);
        
		tx.commit();
		
		
		session.close();
		factory.close();
	}

}
