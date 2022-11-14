package com.nri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class I_TestORMBasic {
	public static void main(String[] args) {
		System.out.println("Hibernate Started....");

		// we need object of configuration
		Configuration config = new Configuration();
		// we need to configure session for hibernate
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();

		System.out.println("session");

		Customer custobj = new Customer();
		custobj.setCustid(13);
		custobj.setCustname("Manshi");
		custobj.setCustcity("Kolkata");
		
		Orders ordobj = new Orders();
		ordobj.setOrdid(121);
		ordobj.setOrdname("Farm fresh pizza");
		ordobj.setOrdprice(500);
		
		custobj.setOrder(ordobj);

		// Now we need to start transaction before asking hibernate to save our object
		// into database
		Transaction tx = session.beginTransaction();

		session.save(custobj);

//        Customer cone = (Customer)session.get(Customer.class,13);
//        System.out.println(cone); --eager loading

	
//		 Customer cone = (Customer)session.load(Customer.class,13);
//		 System.out.println(cone.getCustcity()); --lazy loading
		 

		tx.commit();

		session.close();
		factory.close();
	}
}
