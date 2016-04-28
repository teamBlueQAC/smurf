package com.qa.smurf.repositories;
/**  
* Author - Tom  
*/

import java.util.ArrayList;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.entities.SupplierOrder;
import com.qa.smurf.util.OrderStatus;

public interface SupplierOrderRepository {
	public void persistSupplierOrder(SupplierOrder so);

	public void persistSupplierOrders(ArrayList<SupplierOrder> so);

	public SupplierOrder findByID(long ID);

	public ArrayList<SupplierOrder> findBySupplier(Supplier supplier);

	public ArrayList<SupplierOrder> findByProduct(Product product);

	public ArrayList<SupplierOrder> findByOrderStatus(OrderStatus orderStatus);

	public ArrayList<SupplierOrder> getSupplierOrders();

	public void updateSupplierOrder(SupplierOrder so);

	public void removeSupplierOrder(SupplierOrder so);
}
