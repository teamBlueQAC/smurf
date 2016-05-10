package com.qa.smurf.repositories.offline;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.repositories.SupplierRepository;

@Default
@Stateless
public class SupplierRepositoryOffline implements SupplierRepository {
	@Inject
	private InitialData initialData;

	//
	@Override
	public void persistSupplier(Supplier supplier) {
		initialData.addSupplier(supplier);
	}

	//
	@Override
	public void persistSuppliers(List<Supplier> suppliers) {
		for (Supplier s : suppliers) {
			initialData.addSupplier(s);
		}
	}

	// Search for Supplier by ID
	@Override
	public Supplier findByID(long id) {
		for (Supplier s : initialData.getSuppliers()) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	// Fetch the entire list of Suppliers
	@Override
	public ArrayList<Supplier> getSuppliers() {
		return initialData.getSuppliers();
	}

	// update Address info
	@Override
	public void updateSupplier(Supplier supplier) {

	}

	// delete - most likely wouldn't delete Supplier, we discussed it though
	@Override
	public void removeSupplier(Supplier supplier) {

	}
}
