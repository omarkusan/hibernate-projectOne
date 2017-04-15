package com.omar.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
			try {
				//create a student object
				System.out.println("Creating 3 students objects.....");
				Student tempStudent1 = new Student("Alim","Wall","alim@gmail.com");
				Student tempStudent2 = new Student("Tarim","Wall","tarim@gmail.com");
				Student tempStudent3 = new Student("Tursun","Wall","tursun@gmail.com");

				//start a transaction
				session.beginTransaction();
				
				//save the object
				System.out.println("Saving the student...");
				session.save(tempStudent1);
				session.save(tempStudent2);
				session.save(tempStudent3);
				
				//commit transaction
				session.getTransaction().commit(); 
			}finally {
				factory.close();
			}
	}

}
