package HibernateAgain.com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Student;


/**
 * Hello world!
 *
 */
public class App {
	// Main driver method
	public static void main(String[] args) {

		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);
		
		
		

		// Create Session Factory and auto-close with try-with-resources.
		try {
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// Initialize Session Object
			Session session = sessionFactory.openSession();

			//Student song1 = new Student("3sdf", "45", "676");

			//session.beginTransaction();

			// Here we have used
			// persist() method of JPA
			//session.persist(song1);
			
			Student reference = session.getReference(Student.class , 1);
			System.out.println(reference);
			
			
			

			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
