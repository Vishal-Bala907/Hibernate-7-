package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Student;



public class HQLQueryDemo {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		

		
		List<Student> list = 
				session.createQuery("SELECT s FROM Student as s WHERE s.name =:name",Student.class).
				setParameter("name", "Vishal").getResultList();
		Student student = list.get(0);
		student.setName("Thomas");
		Transaction beginTransaction = session.beginTransaction();
			session.merge(student);
		beginTransaction.commit();
		
		System.out.println(student.getName());
		
		
	}

}
