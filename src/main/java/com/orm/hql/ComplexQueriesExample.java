package com.orm.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class ComplexQueriesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		// Delete Query
		Query que = session.createQuery("delete from Post as p where p.userName = :name");
		que.setParameter("name", "Sanket122_Sawant");
		int rows1 = que.executeUpdate();
		System.out.println("Deleted : "+ rows1 + " affected in DB");
		
		
		// Update Query
		Query que2 = session.createQuery("update Post p set p.userName = :n where p.followersNo = :c");
		que2.setParameter("n", "Tathe.X.Tembha");
		que2.setParameter("c", 1000);
		int rows2 = que2.executeUpdate();
		System.out.println("Updated : "+ rows2 + " affected in DB");
		
		tx.commit();
		session.close();
		factory.close();
	}

}
