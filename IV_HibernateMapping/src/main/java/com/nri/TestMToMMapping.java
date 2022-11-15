package com.nri;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class TestMToMMapping 
{
	public static void main(String[] args) {
		System.out.println("Hibernate Mapping 1M1 Started....");
		
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
		
		Orders ordtwo = new Orders();
		ordtwo.setOrdid(127);
		ordtwo.setOrdname("Chocolate Doughnut");
		ordtwo.setOrdprice(200);
		
		List<Customer> listcust = new ArrayList<Customer>();
		listcust.add(cone);
		listcust.add(ctwo);
		
		List<Orders> listord= new ArrayList<Orders>();
		listord.add(ordone);
		listord.add(ordtwo);
		
		cone.setOrder(listord);
		ordone.setCustomer(listcust);
		
		ctwo.setOrder(listord);
		ordtwo.setCustomer(listcust);
		
		session.save(ordone);
		session.save(ordtwo);	
		
		session.save(cone);
		session.save(ctwo);	 

		tx.commit();

		session.close();
		factory.close();
	}
}
