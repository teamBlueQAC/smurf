package com.qa.smurf.util;

public enum OrderStatus {
	PENDING, PLACED, PROCESSING, AWAITINGDISPATCH, DELIVERED, PAID;
	
	
	//private long id;
	
	//needs review
	public long getId() {
		return this.ordinal();
	}

	//needs review
	public String getName() {
		return this.name();
	}
}