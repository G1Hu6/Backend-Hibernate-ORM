 package com.orm.longobjects;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;
public class SavingImageTestApp {

	public static void main(String[] args) throws java.io.IOException{
		// TODO Auto-generated method stub
		
	    Profile profile = new Profile();
	     profile.setName("Harshal Wande");
	     profile.setDescription("living in khadakwasla Dam and owner of Dam's one gate.");
	     profile.setActivated(true);
	     profile.setAuthorised(true);
	     profile.setDate(new Date());
	     
	     // Reading large image data
	    FileInputStream fis = new FileInputStream("src/main/java/home_1.jpg");
	    byte[] data = new byte[fis.available()];
	    fis.read(data);
	    
	    profile.setProfileImage(data);
		Configuration cnf = new Configuration();
		cnf.configure("hibernate.cfg.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(profile);
		tran.commit();
		
		session.close();
	}

}
