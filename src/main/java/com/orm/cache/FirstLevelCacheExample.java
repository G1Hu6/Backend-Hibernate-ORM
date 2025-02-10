package com.orm.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.orm.Post;

public class FirstLevelCacheExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// by default
		Post post = session.get(Post.class, 1);
		System.out.println(post.getUserName());
		System.out.println("Working....");
		Post post2 = session.get(Post.class, 1);
		System.out.println(post2.getUserName());
		
		session.close();
		factory.close();

	}

}
