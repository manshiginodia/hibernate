package com.nri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Orders {

	@Id
	@Column(name="orderid")
	private int ordid;
	
	@Column(name="ordername")
	private String ordname;
	
	@Column(name="orderprice")
	private double ordprice;
	
	@ManyToOne
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
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
