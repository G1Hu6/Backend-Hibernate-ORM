package com.orm.mapping;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyTestApp {

	public static void main(String[] args) {
		
		Configuration cnf = new Configuration();
		cnf.configure();
		SessionFactory factory = cnf.buildSessionFactory();
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		
		emp1.setId(1111);
		emp1.setName("Pranav");
		emp2.setId(1112);
		emp2.setName("Harshal");
		emp3.setId(1113);
		emp3.setName("Tejas");
		
		Project pro1 = new Project();
		Project pro2 = new Project();
		
		pro1.setProjectId(101);
		pro1.setProjectName("Mead-Vault App");
		pro1.setEmps(Arrays.asList(emp1, emp2, emp3));
		pro2.setProjectId(102);
		pro2.setProjectName("RenewHeat Ecom App");
		pro2.setEmps(Arrays.asList(emp1,emp2));
		
		emp1.setProjects(Arrays.asList(pro1, pro2));
		emp2.setProjects(Arrays.asList(pro1, pro2));
		emp3.setProjects(Arrays.asList(pro1));
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);
		session.persist(pro1);
		session.persist(pro2);
		
		tx.commit();
	
		session.close();
		factory.close();
	}

}
