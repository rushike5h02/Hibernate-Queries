package com.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUpdate {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
//		session.beginTransaction();                      // for ...update
		Transaction t = session.beginTransaction();   //...................for insertion
	
		//pass the class name and id for updating record.................update
//		Student student = (Student)session.get(Student.class, 1);    // for single
				// by add type casting
// for multiple updates.......1,2..etc  are primary key number
		
//		Student s = (Student) session.get(Student.class, 2); 
//		Student s1 = (Student) session.get(Student.class, 1);
//		
//		student.setName("rushi");
//		s.setCity("pune");
//		s1.setMobile("78965");
//		session.update(student);
//			
//		session.getTransaction().commit();
		
		// add into table..................insertion
		
//		Student student = new Student();
//		student.setName("rushikesh");
//		student.setCity("Ahmednagar");
//		student.setMobile("12345");
//		
//		session.save(student);
		
		// to add multiple entries.......multiple
		
		for(int i=1; i<=2; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter name  \n  enter city  \n  enter number ");
			String name = sc.next();
			String city = sc.next();
			String number = sc.next();
			
			Student student = new Student();
			student.setName(name);
			student.setCity(city);
			student.setMobile(number);
			
			session.save(student);
		
		}
		t.commit();
		
		session.close();
		sessionFactory.close();
		
		System.out.println("Record updated successfully.");

	}

}
