/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface SupplierOrderRepository {
	public void persistSupplierOrder(SupplierOrder so);

	public void persistSupplierOrders(List<SupplierOrder> so);

	public SupplierOrder findByID(long id);

	public ArrayList<SupplierOrder> getSupplierOrders();

	public void updateSupplierOrder(SupplierOrder so);

}
