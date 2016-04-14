package com.qa.smurf;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 * class modelling the line items 
 * 
 * 
 * */


@Entity
@Table (name = "LineItems")
public class LineItems {
	
	@Id
	@Column (name = "LineItems")
	@GeneratedValue (
			strategy = GenerationType.IDENTITY)
	private long orderID;
	
	@ManyToMany
	@JoinTable(name = "prodID_fk")
	@NotNull
	private long prodID;
	
	@Column (name = "quantity", length = 10)
	private int quantity;

	@Column (name = "subtotal", length = 12)
	private double subtotal;
	
	@Column (name = "returnedQty", length = 10)
	private int returnedQty;
	
	public long getOrderID(){
		return orderID;
	}
	
	public long prodID(){
		return prodID;
	}
	
	public long getProdID(){
		return prodID;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public double getSubtotal(){
		return subtotal;
	}
	
	public int getReturnedQty(){
		return returnedQty;
	}
	
	public void setOrderID(Long oID){
		this.orderID = oID;
	}
	
	public void setProdID(Long pID){
		this.prodID = pID;
	}
	
	public void setQuantity(int q){
		this.quantity = q;
	}

	public void setSubtotal(double s){
		this.subtotal = s;
	}
	
	public void setReturnedQty(int rQty){
		this.returnedQty = rQty;
	}
}
