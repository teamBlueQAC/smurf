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


	@Entity
	@Table (name = "Payment")
public class Payment {
	
	@Id
	@Column (name = "PAYMENT_ID")
	@GeneratedValue (
			strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "CARDNUMBER", 
			 length = 16)
	private String cardNumber;
	
	
	@Column ( name ="CARDTYPE", length = 20)
	private String cardType;
	
	@Temporal(TemporalType.DATE)
	@Column (name = "EXPIRYDATE", length = 10)
	private Date expiryDate;
	
	@Column ( name = "NAMEONCARD", length= 255)
	private String nameOnCard;
	
	@OneToOne
	@JoinColumn ( name = "USER_ID",
	 nullable = false)
	private User userID;
	
	@JoinColumns({ @JoinColumn(name = "LINE1"),
		@JoinColumn(name = "POSTCODE")})
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	

	
	
}
