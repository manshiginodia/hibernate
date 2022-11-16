package com.nri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Books {

	@Id
	@Column(name="bookid")
	private int bookid;
	
	@Column(name="bookname")
	private String bookname;
	
	@Column(name="bookqty")
	private double bookqty;
	
	@ManyToOne
	private Library library;
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getBookqty() {
		return bookqty;
	}

	public void setBookqty(double bookqty) {
		this.bookqty = bookqty;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", bookqty=" + bookqty + "]";
	}

	
	
}
