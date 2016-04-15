package com.qa.smurf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Order")
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "TOTAL", length = 12, nullable = false)
	@NotNull
	private double total;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", nullable = false)
	@NotNull
	private Date date;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISPATCHDATE", nullable = false)
	@NotNull
	private Date dispatchDate;

	@OneToOne
	@JoinColumn(name = "ORDERSTATUS_ID")
	private OrderStatus orderStatusID;

	@JoinColumns({ @JoinColumn(name = "LINE1"), @JoinColumn(name = "POSTCODE") })
	private Address address;

	@JoinColumns(@JoinColumn(name = " PAYMENT_ID", nullable = false))
	@NotNull
	private Payment paymentID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public OrderStatus getOrderStatusID() {
		return orderStatusID;
	}

	public void setOrderStatusID(OrderStatus orderStatusID) {
		this.orderStatusID = orderStatusID;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Payment getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Payment paymentID) {
		this.paymentID = paymentID;
	}

}
