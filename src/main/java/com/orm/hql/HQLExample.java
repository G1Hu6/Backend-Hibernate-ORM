package com.orm.hql;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.orm.Post;

public class HQLExample {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession(); 
		
		// HQL (Hibernate Query Language)
		String query = "from Post"; // Here Post is an Entity class name
		String query2 = "from Post where userName = 'Tejas_Tathe'";
		String query3 = "from Post where followersNo = 1000";
		
		// Setting dynamic values in where cluse HQL.
		String query4 = "from Post where userName = :name and followersNo = :num";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name :");
		String name = sc.next();
		System.out.println("Enter Followers :");
		int num = sc.nextInt();
		Query que = session.createQuery(query4);
		
		que.setParameter("name", name);
		que.setParameter("num", num);
		
		List<Post> posts = que.list();
		for(Post post : posts) {
			System.out.println(post.getId() + " : " + post.getUserName() +" : " + post.getCaption());
		}
		
		session.close();
		factory.close();
	}
}
