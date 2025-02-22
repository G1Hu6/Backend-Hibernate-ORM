package com.orm.cascading;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.orm.mapping.Employee;
import com.orm.mapping.Project;

public class CascadingExample {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Employee emp1 = new Employee();
		emp1.setId(1115);
		emp1.setName("Sayli");
		
		Project pro1 = new Project();
		pro1.setProjectId(104);
		pro1.setProjectName("Dating App");
		pro1.setEmps(Arrays.asList(emp1));
		
		Project pro2 = new Project();
		pro2.setProjectId(105);
		pro2.setProjectName("Tathe's Kitchen Hotel Design");
		pro2.setEmps(Arrays.asList(emp1));
		emp1.setProjects(Arrays.asList(pro1,pro2));
		
		Transaction tx = session.beginTransaction();
		
		session.persist(emp1);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
