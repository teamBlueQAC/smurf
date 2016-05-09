package com.qa.smurf.util;

public enum OrderStatus {
	PENDING, PLACED, PROCESSING, AWAITINGDISPATCH, DELIVERED, PAIED;
	
	
	//private long id;
	
	//needs review
	public long getId() {
		return this.ordinal();
	}

	//needs review
	public Object getName() {
		return this.name();
	}
}