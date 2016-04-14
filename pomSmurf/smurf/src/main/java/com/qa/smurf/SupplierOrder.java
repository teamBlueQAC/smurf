package com.qa.smurf;

public class SupplierOrder {

	private int id;
	private String orderStatus;
	private int orderAmount;
	private int productID;
	private String dateReceived;
	private int receivedAmount;
	private int supplierID;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	public int getReceivedAmount() {
		return receivedAmount;
	}
	public void setReceivedAmount(int receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	

	
}
