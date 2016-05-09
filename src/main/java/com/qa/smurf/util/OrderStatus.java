package com.qa.smurf.util;

public enum OrderStatus {
	PENDING (0, "Pending"), 
	PLACED (1, "Placed"), 
	PROCESSING (2, "Processing"), 
	AWAITINGDISPATCH (3, "Awaiting Dispatch"), 
	DELIVERED (4, "Delivered"), 
	PAID (5, "Paid");
	
	private final long id;	
	private final String name;
	
	OrderStatus(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	//private long id;
	
	//needs review
	public long getId() {
		return id;
	}

	//needs review
	public String getName() {
		return name;
	}
}