package com.save.or.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Student;

public class PersisitData {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		SessionFactory session = configuration.buildSessionFactory();
		Session sess = session.openSession();

		Transaction transaction = sess.beginTransaction();
		Student student = new Student("Vishal", "123456", "BCA IIIrd");
		student.setId(102);
		
		sess.merge(student);
		transaction.commit();
		


	}

}
