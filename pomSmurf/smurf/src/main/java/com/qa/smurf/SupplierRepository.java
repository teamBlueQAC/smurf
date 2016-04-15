/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface SupplierRepository {

	public void persistSupplier(Supplier s);

	public void persistSuppliers(List<Supplier> s);

	public Supplier findByID(long id);

	public ArrayList<Supplier> getSuppliers();

	public void updateSupplier(Supplier s);

}
