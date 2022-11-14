package com.nri;

import javax.persistence.Embeddable;

@Embeddable
public class Orders {

	private int ordid;
	private String ordname;
	private double ordprice;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrdid() {
		return ordid;
	}
	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	public String getOrdname() {
		return ordname;
	}
	public void setOrdname(String ordname) {
		this.ordname = ordname;
	}
	public double getOrdprice() {
		return ordprice;
	}
	public void setOrdprice(double ordprice) {
		this.ordprice = ordprice;
	}
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", ordname=" + ordname + ", ordprice=" + ordprice + "]";
	}
	
	
	
}
