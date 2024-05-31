package com.embedable.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		
		Skills skills = new Skills("Java","2 years");
		Person person = new Person("Vishal bala","22",skills);
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Person.class);
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(person);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
