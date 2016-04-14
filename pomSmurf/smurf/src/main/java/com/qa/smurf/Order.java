package com.qa.smurf;

import java.util.Date;

public class Order {

	private long id;
	private long userID;
	private double total;
	private Date date;
	private Date dispatchDate;
	private long orderStatusID;
	private long addressID;
	private long paymentID;
	
	public long getID(){
		return id;
	}
	
	public long getUserID(){
		return userID;
	}
	
	public double getTotal(){
		return total;
	}
	
	public Date getDate(){
		return date;
	}
	
	public Date getDispatchDate(){
		return dispatchDate;
	}
	
	public long getOrderStatusID(){
		return orderStatusID;
	}
	
	public long getAddressID(){
		return addressID;
	}
	
	public long getPaymentID(){
		return paymentID;
	}
	
	public void setID(long newID){
		this.id = newID;
	}
	
	public void setUserID(long uID){
		this.userID = uID;
	}
	
	public void setTotal(double t){
		this.total = t;
	}
	
	public void setDate(Date d){
		this.date = d;
	}
	
	public void setDispatchDate(Date dd){
		this.dispatchDate = dd;
	}
	
	public void setOrderStatusID(long os){
		this.orderStatusID = os;
	}
	
	public void setAddressID(long aid){
		this.addressID = aid;
	}
	
	public void setPaymentID(long pid){
		this.paymentID = pid;
	}
}
