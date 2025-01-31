package com.orm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "First Hibernate Program!" );
        Configuration cnf = new Configuration();
        cnf.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cnf.buildSessionFactory();
        
        //SessionFactory factory = new Configuration().configure()
        //		                                    .buildSessionFactory();
        
        System.out.println("SessionFactory Object = " + factory);
        
    }
}
