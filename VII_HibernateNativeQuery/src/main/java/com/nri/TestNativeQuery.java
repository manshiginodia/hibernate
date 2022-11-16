package com.nri;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

/**
 * Hello world!
 *
 */
public class TestNativeQuery {
	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	static Transaction tx;

	private static Session getSession() {
		cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
		s = sf.openSession();
		return s;
	}

	private static void recordInsert() {
		Library libone = new Library();
		libone.setLibid(13);
		libone.setLibname("CS-IT Library");
		libone.setLibmemfee(1500);

		Library libtwo = new Library();
		libtwo.setLibid(14);
		libtwo.setLibname("Mechanics Library");
		libtwo.setLibmemfee(1200);

		Library libthree = new Library();
		libthree.setLibid(14);
		libthree.setLibname("ECE Library");
		libthree.setLibmemfee(1600);

		s = getSession();
		tx = s.beginTransaction();

		s.save(libone);
		s.save(libtwo);
		s.save(libthree);

		tx.commit();
		s.close();
	}

	private static void recordgetAll() {

		s.getSession();

		NativeQuery query = s.createNativeQuery("select * from library");

		List<Object[]> listrows = query.getResultList();

		listrows.forEach(libobj -> {

			for (Object obj : libobj) {
				System.out.println(obj + " ");
			}
			System.out.println();
		});
	}

	private static void recordSearch(int lid) {

		s.getSession();

		NativeQuery query = s.createNativeQuery("select * from library where libid=?");
		query.setParameter(1, lid);

		List<Object[]> listrows = query.getResultList();

		listrows.forEach(libobj -> {
			for (Object obj : libobj) {
				System.out.println(obj + " ");
			}
			System.out.println();
		});
	}

	private static void recordUpdate(int lid,String lname) {

		s.getSession();
		tx= s.beginTransaction();
		
		NativeQuery query = s.createNativeQuery("update library set libname=? where libid=?");
		query.setParameter(1, lname);
		query.setParameter(2, lid);
		
		int count = query.executeUpdate();
		
		System.out.println(count+"record got udated");
		
		tx.commit();
		s.close();
	}
	
	private static void recordDelete(int lid) {

		s.getSession();
		tx= s.beginTransaction();
		
		NativeQuery query = s.createNativeQuery("delete library where libid=?");
		query.setParameter(1, lid);
		
		int count = query.executeUpdate();
		
		System.out.println(count+"record got deleted");
		
		tx.commit();
		s.close();
	}

	public static void main(String[] args) {
		System.out.println("Hibernate native query session using crud operation!");

		recordInsert();
		recordgetAll();
		recordSearch(14);
		recordUpdate(14,"Civil Library");
		recordDelete(15);
	}
}
