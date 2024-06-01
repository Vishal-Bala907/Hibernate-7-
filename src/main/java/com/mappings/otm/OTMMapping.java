package com.mappings.otm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OTMMapping {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(LaptopOwner.class);
		configuration.addAnnotatedClass(Laptop.class);
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
// Getting LaptopOwner and All associated laptops
		LaptopOwner find = session.getReference(LaptopOwner.class, 102);
		System.out.println(find.getPersonName());
//		List<Laptop> list = find.getLaptops();
//		System.out.println(find.getPersonName());
//		for(Laptop laptop : list) {
//			System.out.println(laptop.getLaptopName());
//		}
		
		
//		Getting Laptop and its associated owner
//		Laptop find = session.getReference(Laptop.class, 52);
//		System.out.println(find.getLaptopName());
//		System.out.println(find.getPerson().getPersonName());
		
		
		
//		List<Laptop> list = new ArrayList<Laptop>();
//		
//		LaptopOwner laptopOwner = new LaptopOwner();
//		Laptop laptop1 = new Laptop("HP", laptopOwner);
//		Laptop laptop2 = new Laptop("Dell", laptopOwner);
//		Laptop laptop3 = new Laptop("Lenovo", laptopOwner);
//		Laptop laptop4 = new Laptop("Apple", laptopOwner);
//		list.add(laptop4);
//		list.add(laptop3);
//		list.add(laptop2);
//		list.add(laptop1);
//		
//			laptopOwner.setPersonName("Vishal bala");
//			laptopOwner.setLaptops(list);
//			
//			session.beginTransaction();
//			session.persist(laptopOwner);
//			session.getTransaction().commit();
			
			
		
	}
}
