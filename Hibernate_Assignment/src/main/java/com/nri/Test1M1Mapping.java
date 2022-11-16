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
public class Test1M1Mapping 
{
	public static void main(String[] args) {
		System.out.println("Hibernate Mapping 1M1 Started....");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Library libone = new Library();
		libone.setLibid(13);
		libone.setLibname("CSIT");
		libone.setLibmemfee(1500);
		
		Library libtwo = new Library();
		libtwo.setLibid(14);
		libtwo.setLibname("Mechanics");
		libtwo.setLibmemfee(1200);
		
		Library libthree = new Library();
		libthree.setLibid(14);
		libthree.setLibname("ECE");
		libthree.setLibmemfee(1600);
		
		Books bookone = new Books();
		bookone.setBookid(101);
		bookone.setBookname("Java");
		bookone.setBookqty(5);
		bookone.setLibrary(libone);
		
		Books booktwo = new Books();
		booktwo.setBookid(102);
		booktwo.setBookname("Python");
		booktwo.setBookqty(7);
		booktwo.setLibrary(libone);
		
		Books bookthree = new Books();
		bookthree.setBookid(103);
		bookthree.setBookname("Dynamics");
		bookthree.setBookqty(4);
		bookthree.setLibrary(libtwo);
		
		Books bookfour = new Books();
		bookfour.setBookid(104);
		bookfour.setBookname("Motion");
		bookfour.setBookqty(8);
		bookfour.setLibrary(libtwo);
		
		Books bookfive = new Books();
		bookfive.setBookid(105);
		bookfive.setBookname("Network");
		bookfive.setBookqty(10);
		bookfive.setLibrary(libthree);
		
		Books booksix = new Books();
		booksix.setBookid(106);
		booksix.setBookname("Cloud Computing");
		booksix.setBookqty(2);
		booksix.setLibrary(libthree);
		
		session.save(bookone);
		session.save(booktwo);	
		session.save(bookthree);	
		session.save(bookfour);	
		session.save(bookfive);	
		session.save(booksix);
		
		List<Books> listbook1= new ArrayList<Books>();
		listbook1.add(bookone);
		listbook1.add(booktwo);
		
		
		List<Books> listbook2= new ArrayList<Books>();
		listbook1.add(bookthree);
		listbook2.add(bookfour);
		
		
		List<Books> listbook3= new ArrayList<Books>();
		listbook3.add(bookfive);
		listbook3.add(booksix);
		
		libone.setBooks(listbook1);
		libtwo.setBooks(listbook2);
		libthree.setBooks(listbook3);

		session.save(libone);
		session.save(libtwo);
		session.save(libthree);

		tx.commit();

		session.close();
		factory.close();
	}
}
