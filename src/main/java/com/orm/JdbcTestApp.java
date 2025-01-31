package com.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;
public class JdbcTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	    Post post1 = new Post();
	    post1.setId(1);
	    post1.setUserName("Harshal Wande");
	    post1.setFollowersNo(234);
	    post1.setCaption("Chal Daru Pine Chaltehe...");
	    
	    Post post2 = new Post(3,"Tejas_Tathe", 1000, "I am big fan of Sayli >>>");
	    Post post5 = new Post(4,"Tejas_Tathe", 1000, "Django one love");
	    Post post3 = new Post(5,"Sanket122_Sawant", 200, "My fav days are wednesday and saturday");
	    Post post4 = new Post(6,"Sahil_e_mubarakha", 1000, "Alla huu huu Akbar,, HUuuu huuu...");
		*/
		
		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		
		for(int i = 7; i < 40; i++) {
			Post post = new Post(i,"User_name_"+i, 1000+i, "Comment_"+i);
			session.persist(post);
		}
		tran.commit();
		
		session.close();
	}

}
