package com.qa.smurf;

public class LineItems {
	
	private long orderID;
	private long prodID;
	private int quantity; 
	private double subtotal;
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
