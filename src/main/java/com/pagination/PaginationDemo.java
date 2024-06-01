package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.Student;

import org.hibernate.Transaction;

public class PaginationDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session =factory.openSession();
		
//		Pagination
		
		Query<Student> createQuery = session.createQuery("from Student",Student.class);
		
		// From where to start fetching
		createQuery.setFirstResult(0);
		
		// How many records need to fetch
		createQuery.setMaxResults(5);
		
		List<Student> resultList = createQuery.getResultList();
		
		for(Student student : resultList) {
			System.out.println(student.getName());
		}
		
		
		
//		for(int i=0;i<20;i++) {
//			Transaction transaction = session.beginTransaction();
//			session.persist(new Student("Name " + i, "234" + i, " class " + i));
//			transaction.commit();
//		}
		
	}
}
