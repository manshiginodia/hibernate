package com.nri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tblcustomer")
public class Customer {
	
	@Id
	@Column(name="customerid")
	private int custid;
	
	@Column(name="customername")
	private String custname;
	
	@Column(name="customercity")
	private String custcity;
	
	//one customer will have only one order
	@OneToOne
	@JoinColumn(name="ord_id")
	private Orders order;
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustcity() {
		return custcity;
	}
	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custcity=" + custcity + "]";
	}
	
	

}
