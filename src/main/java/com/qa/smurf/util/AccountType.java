package com.qa.smurf.util;

public enum AccountType {
	InventoryManager(0, "Inventory Manager"), 
	WarehouseWorker(1, "Warehouse worker");
	
	private final long id;	
	private final String name;
	
	AccountType(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {		
		return id;
	}

	public String getName() {
		return name;
	}
}