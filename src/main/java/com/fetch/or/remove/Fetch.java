package com.fetch.or.remove;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Student;

class FetchStudentDemoMethods {
	private int id;
	private Student student;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	public FetchStudentDemoMethods() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	public void getStudentUsingGetReferenceMethod(int id) {
		this.id = id;
		student = session.getReference(Student.class, this.id);
		System.out.println(student.getName());

	}

	public void getStudentUsingFind(int id) {
		this.id = id;
		student = session.find(Student.class, this.id);
		System.out.println(student);
	}

	public void getStudentUsingGet(int id) {
		this.id = id;
		student = session.get(Student.class, this.id);
		System.out.println(student);
	}

	public void getStudentUsingById(int id) {
		this.id = id;
		student = session.byId(Student.class).load(id);
		System.out.println(student);
	}

	public void getDataBySimpleNaturalIdMethod(int id) {
		Student reference = session.bySimpleNaturalId(Student.class).getReference(102);
		System.out.println(reference);
	}

	public void getMultipleData(int[] arr) {
		List<Student> students = session.byMultipleIds(Student.class).enableOrderedReturn(false).multiLoad(arr[0],
				arr[1], arr[2]);
		for (Student stu : students) {
			System.out.println(stu.getName());
		}
	}

	public void getMultipleDataThruSessionCheck(int[] arr) {
		List<Student> students = session.byMultipleIds(Student.class).enableSessionCheck(true).multiLoad(arr[0], arr[1],
				arr[2]);
		for (Student stu : students) {
			System.out.println(stu.getName());
		}
	}
	
//TODO Remove/deleting
	public void removeData() {
		session.remove(session.find(Student.class, 52));
		transaction.commit();
	}

}

public class Fetch {
	public static void main(String[] args) {
		FetchStudentDemoMethods methods = new FetchStudentDemoMethods();
//		methods.getStudentUsingById(1);
//		methods.getStudentUsingFind(52);
//		methods.getMultipleData(new int[]{52,102,1});
//		methods.getMultipleData(new int[]{2,102,1});
//		methods.getDataBySimpleNaturalIdMethod(0);
//		methods.removeData();
		methods.getStudentUsingGetReferenceMethod(52);
	}

}
