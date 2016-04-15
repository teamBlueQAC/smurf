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
	private Order order;
	
	@ManyToMany
	@JoinTable(name = "PRODUCT_ID")
	@NotNull
	private Product product;
	
	@Column (name = "QUANTITY", length = 10)
	private int quantity;

	@Column (name = "SUBTOTAL", length = 12)
	private double subtotal;
	
	@Column (name = "RETURNEDQTY", length = 10)
	private int returnedQty;
	
	public long getOrder(){
		return order;
	}
	
	public Product getProd(){
		return product;
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
	
	public void setOrderID(Order o){
		this.order = o;
	}
	
	public void setProdID(Product p){
		this.product = p;
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
