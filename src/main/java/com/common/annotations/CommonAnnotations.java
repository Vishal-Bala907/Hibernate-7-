package com.common.annotations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CommonAnnotations {
	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Address.class);
		configuration.configure("hibernate.cfg.xml");
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			
			Address address = new Address("Dadabari","Kota",true,3425.456d, new Date(),null);
			
			try (FileInputStream fileInputStream = new FileInputStream("src/main/java/pic.jpg")) {
				byte[] img = new byte[fileInputStream.available()];
				fileInputStream.read(img);
				address.setImage(img);
			}
			session.beginTransaction();
//			session.persist(address);
			
			Address address2 = session.get(Address.class, 1);
			
			System.out.println(address2);
//			session.merge(address);
			
			session.getTransaction().commit();
			session.close();
	}
}
