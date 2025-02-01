package com.orm.mapping;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneTestApp {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		//--------------------------------------------------
		
		// question 1
		Question q1 = new Question();
		q1.setQuestion("Select the Programming language that not uses pointers concept ?");

		// option 1
		Option op1 = new Option();
		op1.setOption("Cpp");
		op1.setCorrect(false);
		op1.setQuestion(q1);
		
		// option 2
		Option op2 = new Option();
		op2.setOption("C");
		op2.setCorrect(false);
		op2.setQuestion(q1);
		
		// option 3
		Option op3 = new Option();
		op3.setOption("Java");
		op3.setCorrect(true);
		op3.setQuestion(q1);
		
		// option 4
		Option op4 = new Option();
		op4.setOption("Swift");
		op4.setCorrect(false);
		op4.setQuestion(q1);
		
		Answer ans1 = new Answer();
		ans1.setOption(op3);
		ans1.setAnswer("Java");
		ans1.setQue(q1);
		
		q1.setOptions(Arrays.asList(op1, op2, op3, op4));
		
		//--------------------------------------------------
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(q1);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
