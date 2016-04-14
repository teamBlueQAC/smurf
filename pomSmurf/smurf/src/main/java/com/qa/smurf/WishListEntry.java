package com.qa.smurf;

import java.util.Date;

public class WishListEntry {

	private long prodID;
	private long userID;
	private Date dateAdded;
	
	public long getProdID() {
		return prodID;
	}
	public void setProdID(long prodID) {
		this.prodID = prodID;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
