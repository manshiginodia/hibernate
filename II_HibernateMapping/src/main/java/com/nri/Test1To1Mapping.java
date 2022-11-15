package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Test1To1Mapping 
{
	public static void main(String[] args) {
		System.out.println("Hibernate Mapping Started....");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Customer cone = new Customer();
		cone.setCustid(13);
		cone.setCustname("Manshi");
		cone.setCustcity("Kolkata");
		
		Customer ctwo = new Customer();
		ctwo.setCustid(14);
		ctwo.setCustname("Krishna");
		ctwo.setCustcity("Kolkata");
		
		Orders ordone = new Orders();
		ordone.setOrdid(121);
		ordone.setOrdname("Farm fresh pizza");
		ordone.setOrdprice(500);
		ordone.setCustomer(cone);
		
		Orders ordtwo = new Orders();
		ordtwo.setOrdid(127);
		ordtwo.setOrdname("Chocolate Doughnut");
		ordtwo.setOrdprice(200);
		ordtwo.setCustomer(ctwo);
		
		session.save(ordone);
		session.save(ordtwo);	
		
		cone.setOrder(ordone);
		ctwo.setOrder(ordtwo);

		session.save(cone);
		session.save(ctwo);		 

		tx.commit();

		session.close();
		factory.close();
	}
}
