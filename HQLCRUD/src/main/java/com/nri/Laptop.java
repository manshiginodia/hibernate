package com.nri;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

	@Id
	private int lapid;
	private String lapname;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLapid() {
		return lapid;
	}
	public void setLapid(int lapid) {
		this.lapid = lapid;
	}
	public String getLapname() {
		return lapname;
	}
	public void setLapname(String lapname) {
		this.lapname = lapname;
	}
	@Override
	public String toString() {
		return "Laptop [lapid=" + lapid + ", lapname=" + lapname + "]";
	}
	
	
}
