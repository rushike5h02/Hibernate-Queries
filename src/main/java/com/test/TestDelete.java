package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestDelete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//pass the class name and id for delete record
 		//we use load or get () method to get the id from database.
		Student student = (Student)session.load(Student.class, 3);     // ..1,2, etc ..are id from db
		
		session.delete(student);
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		
		System.out.println("Record deleted successfully.");


	}

}
