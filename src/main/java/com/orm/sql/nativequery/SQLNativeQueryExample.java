package com.orm.sql.nativequery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.orm.Post;

public class SQLNativeQueryExample {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession(); 
		
		// Native SQL Query is database dependent that is we have to write different queries for different databases.
		// so, it is not recommended in Hibernate.
		String query = "select * from post"; // Pure SQL query
		List<Post> posts = session.createNativeQuery(query, Post.class)
								.setFirstResult(0)  
								.setMaxResults(10)
				                .getResultList();
		for(Post post : posts) {
			System.out.println(post.getId() + " : " + post.getUserName());
		}
		session.close();
		factory.close();
	}

}
