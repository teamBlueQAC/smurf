package com.qa.smurf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SupplierOrder")
public class SupplierOrder {

	@Id
	@Column(name = "SUPPLIERORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierOrderID;

	@Column(name = "ORDERSTATUS")
	private OrderStatus orderStatus;

	@Column(name = "ORDERAMOUNT", length = 20)
	private int orderAmount;

	@ManyToOne
	@JoinTable(name = "PRODUCT_ID")
	private Product product;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATERECEIVED", length = 10)
	private Date dateReceived;

	@Column(name = "RECEIVEDAMOUNT", length = 20)
	private int receivedAmount;

	@ManyToOne
	@JoinTable(name = "SUPPLIER_ID")
	private long supplierID;

	public long getId() {
		return supplierOrderID;
	}

	public void setId(int id) {
		this.supplierOrderID = id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Product getProductID() {
		return product;
	}

	public void setProductID(Product product) {
		this.product = product;
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
