package com.test;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRetrival { 
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// pass the class name
		Query query = session.createQuery("from Student");
		
		List<Student>students = query.list();
		
		for (Student student : students) {
			
			System.out.println("ID="+student.getId());
			System.out.println("City="+student.getCity());
			System.out.println("Mobile="+student.getMobile());
			System.out.println("Name="+student.getMobile());
		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		System.out.println("Record retrieved successfully.");

	}

}
