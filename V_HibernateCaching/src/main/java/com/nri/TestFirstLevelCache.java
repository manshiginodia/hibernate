package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestFirstLevelCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hibernate first level cache is enabled by default");
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
//		Employee empobj = new Employee();
//		empobj.setEmpid(13);
//		empobj.setEmpname("Manshi");
//		empobj.setEmpcity("Kolkata");
		
//		session.save(empobj);	
		
		Employee empobjone = session.get(Employee.class,11);
		System.out.println(empobjone);
		
		System.out.println("code running on something else");
		 
//		Employee empobjtwo = session.get(Employee.class,11);
//		System.out.println(empobjtwo);

		tx.commit();
		session.close();
		
		
		Session session2 = factory.openSession();
		Transaction tx2 = session.beginTransaction();
		
		Employee empobjtwo = session.get(Employee.class,11);
		System.out.println(empobjtwo);
		
		tx2.commit();
		session2.close();

		factory.close();
	}

}
