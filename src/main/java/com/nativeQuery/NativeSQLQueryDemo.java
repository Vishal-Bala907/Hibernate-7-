package com.nativeQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class NativeSQLQueryDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		String sqlString = "SELECT * FROM student";
//		NativeQuery nqueNativeQuery = session.createSQLQuery(sqlString);
//		List<Object[]> list = session.getResultList(sqlString);
//		
//		for(Objest[] arr : list){
//		sout(arr[index])
//	}
//		
	}
}
