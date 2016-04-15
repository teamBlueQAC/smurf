package com.qa.smurf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/*
 * Class modelling the Supplier_Order
 * 
 * 
 * */
@Entity
@Table (name = "SupplierOrder")
public class SupplierOrder {

	@Id
	@Column (name = "SUPPLIERORDER_ID")
	@GeneratedValue (
			strategy = GenerationType.IDENTITY)
	private long supplierOrderID;
	
	@Column (name = "ORDERSTATUS",
			nullable = false, length = 225)
	@NotNull
	@Size(min = 2, max = 225)
	private String orderStatus;
	
	@Column (name = "ORDERAMOUNT", length = 20)
	private int orderAmount;
	
	@ManyToMany
	@NotNull
	@JoinTable(name = "PRODUCT_ID")
	private int productID;
	
	@Temporal(TemporalType.DATE)
	@Column (name = "DATERECEIVED", length = 10)
	private Date dateReceived;
	
	@Column (name = "RECEIVEDAMOUNT", length = 20)
	private int receivedAmount;
	
	@ManyToMany
	@Column (length = 12)
	@NotNull
	@JoinTable(name = "SUPPLIER_ID")
	private long supplierID;
	
	
	public long getId() {
		return supplierOrderID;
	}
	
	public void setId(int id) {
		this.supplierOrderID = id;
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
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public int getReceivedAmount() {
		return receivedAmount;
	}
	public void setReceivedAmount(int receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	public long getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
	}
	

	
}
