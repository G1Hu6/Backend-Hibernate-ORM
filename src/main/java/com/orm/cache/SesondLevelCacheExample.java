package com.orm.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;

import com.orm.Post;


public class SesondLevelCacheExample {

	public static void main(String[] args) {
		 ;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		/*
		   @Cacheable
		   @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
		*/
		
		//first
		Session session1 = factory.openSession();
		Post post1 = session1.get(Post.class, 3);
		System.out.println(post1);
		//java.util.List<Post> posts1 = session1.createQuery("from Post p",Post.class)
		//	.getResultList();
		
		session1.close();
		
		//second
		Session session2 = factory.openSession();
		Post post2 = session2.get(Post.class, 3);
		System.out.println(post2);
		//java.util.List<Post> posts2 = session2.createQuery("from Post p",Post.class)
		//		.getResultList();
		session2.close();
	}

}
