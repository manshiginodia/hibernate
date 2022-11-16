package com.nri;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="tblcustomer")
public class Library {
	
	@Id
	@Column(name="libraryid")
	private int libid;
	
	@Column(name="libraryname")
	private String libname;
	
	@Column(name="memberfee")
	private int libmemfee ;
	
	@OneToMany(mappedBy ="library", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Books> books;

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLibid() {
		return libid;
	}

	public void setLibid(int libid) {
		this.libid = libid;
	}

	public String getLibname() {
		return libname;
	}

	public void setLibname(String libname) {
		this.libname = libname;
	}

	public int getLibmemfee() {
		return libmemfee;
	}

	public void setLibmemfee(int libmemfee) {
		this.libmemfee = libmemfee;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [libid=" + libid + ", libname=" + libname + ", libmemfee=" + libmemfee + ", books=" + books
				+ "]";
	}
	
	
	
	

}
