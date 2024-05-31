package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Student;

public class HQLQueryDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
		
		List<Student> list = session.createQuery("SELECT s FROM Student as s WHERE s.name =:name",Student.class).
				setParameter("name", "Vishal").getResultList();
		
		System.out.println(list.size());
	}

}
