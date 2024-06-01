package com.cacheing.secondLevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Student;

/* 1st Step:
 * 
 * Add the dependency
 * <!-- https://mvnrepository.com/artifact/net.sf.ehcache/ehcache -->
 *	<dependency>
 *	    <groupId>net.sf.ehcache</groupId>
 *	    <artifactId>ehcache</artifactId>
 *	    <version>2.10.9.2</version>
 *	</dependency>
 *	
 *
 *	<!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-ehcache -->
 *	<dependency>
 *	    <groupId>org.hibernate.orm</groupId>
 *	    <artifactId>hibernate-ehcache</artifactId>
 *	    <version>6.0.0.Alpha7</version>
 *	</dependency>
 *============================================================================
 *	
 *2nd Step:
 *
 *	Add these following properties in configuration xml file
 *	<property name="hibernate.cache.use_second_level_cache">true </property>
 *   <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>
 *============================================================================
 *
 *3rd Step:
 *
 *	Add these Annotation on that Entity class to which you want to enable for caching
 *	(Adding at Student class)
 *	 @Cacheable
 *	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
 * 
 * 
 * */

public class SecondLevelDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session1 = factory.openSession();
		Student find = session1.find(Student.class, 202);
		System.out.println(find.getName());
		session1.close();

//		**********************
		
		Session session2 = factory.openSession();
		Student find2 = session2.find(Student.class, 202);
		System.out.println(find2.getName());
		session2.close();
	}
}
