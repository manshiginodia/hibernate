package com.nri;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHQLApp {
	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	static Transaction tx;

	private static Session getSession() {
		cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainees.class)
				.addAnnotatedClass(Laptop.class);
		sf = cfg.buildSessionFactory();
		s = sf.openSession();
		return s;
	}

	private static void recordCreate() {

		Laptop lone = new Laptop();
		lone.setLapid(12);
		lone.setLapname("Dell");

		Trainees tone = new Trainees();
		tone.setTid(20);
		tone.setTname("Manshi");
		tone.setTmarks(100);
		tone.setLaptop(lone);

		Laptop ltwo = new Laptop();
		ltwo.setLapid(14);
		ltwo.setLapname("HP");

		Trainees ttwo = new Trainees();
		ttwo.setTid(22);
		ttwo.setTname("Mohan");
		ttwo.setTmarks(200);
		ttwo.setLaptop(ltwo);

		Laptop lthree = new Laptop();
		lthree.setLapid(15);
		lthree.setLapname("MAC");

		Trainees tthree = new Trainees();
		tthree.setTid(24);
		tthree.setTname("Mark");
		tthree.setTmarks(400);
		tthree.setLaptop(lthree);

		s = getSession();

		tx = s.beginTransaction();

		s.save(lone);
		s.save(ltwo);
		s.save(lthree);

		s.save(tone);
		s.save(ttwo);
		s.save(tthree);

		tx.commit();
		s.close();

	}

	private static void recordRetrieveAll() {

		s = getSession();

		// SQL = select * from tablename
		// HQL = fromclassname

		Query query = s.createQuery("from Trainees");

		List<Trainees> listr = query.getResultList();

		for (Trainees t : listr) {
			System.out.println(t);
		}

		s.close();
	}
	
	private static void recordRetrieveUnique(int trid) {

		s = getSession();

		// SQL = select * from tablename where colname = ? 
		// HQL = from classname where variablename = :NamedParameter

		Query query = s.createQuery("from Trainees where tid= :traieeid");
		query.setLong("traineeid", trid);

		Trainees tr = (Trainees)query.uniqueResult();

		System.out.println(tr);
		s.close();
	}
	
	private static void recordUpdate(int trid,String trname) {

		s = getSession();
		tx= s.beginTransaction();	

		Query query = s.createQuery("update Trainees set tname = :traineename where tid= :traieeid");
		query.setString("traineename", trname);
		query.setLong("traineeid", trid);

		int count = query.executeUpdate();
		
		System.out.println(count+" record got updated");
		
		tx.commit();
		s.close();
	}
	
	private static void recordDelete(int trid) {

		s = getSession();
		tx= s.beginTransaction();	

		//the parent must be dropped first only then the child can be dropped
		//here first trainee needs to be dropped only then its corresponding laptop will be dropped
		Query query = s.createQuery("delete Trainees where tid= :traieeid");
		query.setLong("traineeid", trid);
		
//		Query query = s.createQuery("delete laptop where lapid= :laptopid");
//		query.setLong("laptopid", lapid);


		int count = query.executeUpdate();
		
		System.out.println(count+" record got deleted");
		
		tx.commit();
		s.close();
	}


	public static void main(String[] args) {
		System.out.println("Hibernate Trainess- Laptop tracking CRUD app using HQL");

		recordCreate();
		recordRetrieveAll();
		recordRetrieveUnique(22);
		recordUpdate(22,"Dell");
		recordDelete(22);
		
	}
}
