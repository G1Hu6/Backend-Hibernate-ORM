package com.orm.pagination;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.orm.Post;

public class HQLPagination {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query<Post> query = session.createQuery("from Post", Post.class);
		query.setFirstResult(0);
		query.setMaxResults(30);
		List<Post> posts = query.getResultList();
		
		for(Post post : posts) {
			System.out.println(post.getUserName() + " : " + post.getId());
		}
		
		session.close();
		factory.close();
	}

}
