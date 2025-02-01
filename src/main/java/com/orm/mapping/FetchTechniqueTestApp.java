package com.orm.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchTechniqueTestApp {

	public static void main(String[] args) {
		/*
		 * Fetch Technique Theory 
		 * 1. Lazy 
		 * 2. Eager
		 */
		
		// By default fetch technique used is Lazy
		// If we have to specify the Eager loading explicitly then specify in Mapping annotation
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .buildSessionFactory(); 
		Session session = factory.openSession();
		
		Employee employee1 = session.get(Employee.class, 1112);
		System.out.println("Emp Id = " + employee1.getId());
		System.out.println("Emp Name = " + employee1.getName());
		System.out.println("Emp Projects = ");
		
		for(Project pro : employee1.getProjects()) {
			System.out.println(pro.getProjectId() + " : " + pro.getProjectName());
			for(Employee emp : pro.getEmps()) {
				System.out.print(emp.getName() + ", ");
			}
			System.out.print("\n");
		}
		session.close();
		factory.close();
	}

}
