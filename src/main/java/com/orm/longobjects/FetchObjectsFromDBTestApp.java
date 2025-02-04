package com.orm.longobjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.orm.Post;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchObjectsFromDBTestApp {
	
	public static void main(String[] args) {
		
		// for Fetching object of Entity class( that are defined by programmer) from Database
		// there are two ways :-
		// 1. get(EntityClasstype, int id);
			  /*
			   * 1) get method returns null if it doesn't found object with provided id.
			   * 2) get method fire select query as soon as we call the method.if required  
			   *    object is present in the session cache memory then it does not execute query
			   * 3) If there is possibility for not getting data then we have to use get.
			   */
		// 2. load(EntityClasstype, int id);
		      /*
		       * 1) load method throws ObjectNotFoundException if it doesn't found object 
		       *    with provided id.
		       * 2) When we call load method it returns a proxy object and It initializes the object 
		       *    or hit database only if ( we use this object) method other than getId() is 
		       *    called on object.
		       *    It Increases Performance
		       * 3) use if are you sure that object exists.
		       */
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure(StandardServiceRegistryBuilder.DEFAULT_CFG_RESOURCE_NAME).buildSessionFactory();
		
		// Getting Session object
		Session session = factory.openSession();
		
		// Fetching data from database using get() method
//		Profile profileObj1 = session.get(Profile.class, 3); 
//		Profile profileObj2 = session.get(Profile.class, 3); 
//		System.out.println(profileObj1);
		
		// Fetching data from database using load() method
		Profile profileObj3 = session.load(Profile.class, 1);
		Post profileObj4 = session.load(Post.class, 1);
		Post profileObj5 = session.load(Post.class, 1);
		/*
		 * If row with given id is not present in database then load() method throws ObjectNotFountException
		 * Exception in thread "main" org.hibernate.ObjectNotFoundException: No row with the given identifier 
		 * exists: [com.orm.longobjects.Profile#100]
		 */
//		System.out.println(profileObj3);
//		System.out.println(profileObj3.getProfileId());
//		System.out.println(profileObj4);
//		System.out.println(profileObj4.getId());
		System.out.println(profileObj3.getClass().getName());
		System.out.println(profileObj4.getClass().getName());
		System.out.println(profileObj5.getClass());
		
		session.close();
		factory.close();
	}
}
