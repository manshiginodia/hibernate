package com.nri;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trainees {
	
	@Id
	private int tid;
	private String tname;
	private double tmarks;
	
	@OneToOne
	private Laptop laptop;

	public Trainees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public double getTmarks() {
		return tmarks;
	}

	public void setTmarks(double tmarks) {
		this.tmarks = tmarks;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Trainees [tid=" + tid + ", tname=" + tname + ", tmarks=" + tmarks + ", laptop=" + laptop + "]";
	}

}
