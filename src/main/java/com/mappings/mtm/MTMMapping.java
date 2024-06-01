package com.mappings.mtm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MTMMapping {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Project.class).addAnnotatedClass(Employee.class);
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		
		Employee vishal = new Employee();
		vishal.setEmpName("Vishal");
		
		Employee thomas = new Employee();
		thomas.setEmpName("Thomas");
		
		Employee arthur = new Employee();
		arthur.setEmpName("Arthur");
		
		Employee jhon = new Employee();
		jhon.setEmpName("Jhon");
		
			Project project1 = new Project();
			project1.setProjectName("Spring boot backend");
			
			Project project2 = new Project();
			project2.setProjectName("Rest API");
			
			Project project3 = new Project();
			project3.setProjectName("MERN Cafe");
			
			Project project4 = new Project();
			project4.setProjectName("Project management");
			
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(jhon);
			employees.add(arthur);
			employees.add(vishal);
			employees.add(thomas);
			
			List<Project> projects = new ArrayList<Project>();
			projects.add(project4);
			projects.add(project3);
			projects.add(project2);
			projects.add(project1);
			
			
			vishal.setProjects(projects);
			project1.setEmployees(employees);
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
				session.persist(vishal);
				session.persist(project1);
				transaction.commit();
			session.close();
			factory.close();
			
	}

}
