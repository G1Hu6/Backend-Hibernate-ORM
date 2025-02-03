package com.orm.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.orm.Post;

public class HibernateObjectStateTestApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		// Creating Student class object
		Post post = new Post();
		post.setId(2);
		post.setUserName("Raj Musale");
		post.setFollowersNo(405);
		post.setCaption("I am unbeatable");
		/*
		 * Transient State :-
		 *      1. Here we create Post object and set its variables using
		 *         setters and getter methods then the object is in 
		 *         Transient State.
		 *      2. object which is present in Transient State has not 
		 *         associated to database nor session.
		 */
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//post.setUserName("Harshal_President");
		session.persist(post);
		/*
		 * Persistent State :-
		 * 		1. After using save(Object) or persist(Object) on session 
		 *         instance, object is goes into Persistent State.
		 *      2. object which is present in Persistent State has 
		 *         associated to both database and session.
		 */
		
		Post fetchedPostObj = session.get(Post.class, 1);
		session.remove(fetchedPostObj);
		
		tx.commit(); // To save data permanently in database
		
		session.close();	// After closing session the object is no more associated with session and database.
		
		post.setUserName("Tejas MLpython");
		System.out.println(post);
		/*
		 * Detached State :-
		 * 		1. After closing session the object is no more associated with session and database
		 */
		factory.close();
	}

}
