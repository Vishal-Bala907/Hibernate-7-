package com.mappings.oto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OTOMapping {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(UniQuestion.class);
		configuration.addAnnotatedClass(UniAnswer.class);
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
			
//		UniAnswer answer = new UniAnswer("MongoDB ,ExpressJs , ReactJs ,NodeJs");
//		UniQuestion question = new UniQuestion("Full form of MERN Stack ",answer);
		
//		Transaction transaction = session.beginTransaction();
//		session.persist(question);
//		transaction.commit();
		
//		UniQuestion reference = session.getReference(UniQuestion.class , 1);
//		reference.setQuestion("Explain java ?");
//		System.out.println("Merging...");
//		session.merge(reference);
//		System.out.println("Merger successfull...");
		
		UniQuestion afterReference = session.getReference(UniQuestion.class , 1);
		System.out.println(afterReference.toString());
		
//		System.out.println(afterReference.toString());
		
		factory.close();
		session.close();
	}
}
