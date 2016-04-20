package com.qa.smurf;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Supplier;

public interface SupplierRepository {
	
	// 
	public void persistSupplier (Supplier supplier);
	
	// 
	public void persistSuppliers(List<Supplier> supplier);
	
	// Search for Supplier by ID 
	public Supplier findByID(long id);
	
	// Fetch the entire list of Suppliers
	public ArrayList<Supplier> getSuppliers();
	
	// update Address info
	public void updateSupplier(Supplier supplier);
	
	// delete - most likely wouldn't delete Supplier, we discussed it though
	public void removeSupplier(Supplier supplier);
	
}
