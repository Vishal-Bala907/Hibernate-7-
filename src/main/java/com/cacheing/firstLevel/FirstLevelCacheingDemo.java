package com.cacheing.firstLevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Student;

public class FirstLevelCacheingDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		// Database hit will be occured only once
		
		Student find = session.find(Student.class, 210);
		Student find1 = session.find(Student.class, 210);
		Student find2 = session.find(Student.class, 210);
		Student find3 = session.find(Student.class, 210);
		
		System.out.println(session.contains(find3));
		
		session.close();
		factory.close();
	}
}
