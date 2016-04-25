package com.qa.smurf.repositories.offline;
/**  
* Author - Tom  
*/  

import java.util.ArrayList;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.entities.SupplierOrder;
import com.qa.smurf.repositories.SupplierOrderRepository;
import com.qa.smurf.util.OrderStatus;

public class SupplierOrderRepositoryOffline
implements SupplierOrderRepository{
	@Inject
	private InitialData initialData;

	@Override
	public void persistSupplierOrder(SupplierOrder so) {
		initialData.addSupplierOrder(so);
	}

	@Override
	public void persistSupplierOrders(ArrayList<SupplierOrder> so) {
		initialData.setSupplierOrders(so);
	}

	@Override
	public SupplierOrder findByID(long ID) {
		ArrayList<SupplierOrder> supplierOrders = initialData.getSupplierOrders();
		SupplierOrder supplierOrder = null;
		for(int i = 0; i < supplierOrders.size(); i++) {
			if(supplierOrders.get(i).getId() == ID){
				supplierOrder = supplierOrders.get(i);
				break;
			}
		}
		return supplierOrder;
	}

	@Override
	public ArrayList<SupplierOrder> findBySupplier(Supplier supplier) {
		ArrayList<SupplierOrder> supplierOrders = initialData.getSupplierOrders();
		ArrayList<SupplierOrder> foundSupplierOrders = new ArrayList<SupplierOrder>();
		for(int i = 0; i < supplierOrders.size(); i++) {
			if(supplierOrders.get(i).getSupplier().equals(supplier)){
				foundSupplierOrders.add(supplierOrders.get(i));
			}
		}
		return foundSupplierOrders;
	}

	@Override
	public ArrayList<SupplierOrder> findByProduct(Product product) {
		ArrayList<SupplierOrder> supplierOrders = initialData.getSupplierOrders();
		ArrayList<SupplierOrder> foundSupplierOrders = new ArrayList<SupplierOrder>();
		for(int i = 0; i < supplierOrders.size(); i++) {
			if(supplierOrders.get(i).getSupplier().equals(product)){
				foundSupplierOrders.add(supplierOrders.get(i));
			}
		}
		return foundSupplierOrders;
	}

	@Override
	public ArrayList<SupplierOrder> findByOrderStatus(OrderStatus orderStatus) {
		ArrayList<SupplierOrder> supplierOrders = initialData.getSupplierOrders();
		ArrayList<SupplierOrder> foundSupplierOrders = new ArrayList<SupplierOrder>();
		for(int i = 0; i < supplierOrders.size(); i++) {
			if(supplierOrders.get(i).getSupplier().equals(orderStatus)){
				foundSupplierOrders.add(supplierOrders.get(i));
			}
		}
		return foundSupplierOrders;
	}

	@Override
	public ArrayList<SupplierOrder> getSupplierOrders() {
		return initialData.getSupplierOrders();
	}

	@Override
	public void updateSupplierOrder(SupplierOrder supplierOrder) {
		ArrayList<SupplierOrder> supplierOrders  = initialData.getSupplierOrders();
		for(int i=0; i<supplierOrders.size(); i++) {
			if(supplierOrders.get(i).equals(supplierOrder))
				supplierOrders.set(i, supplierOrder);
		}
		initialData.setSupplierOrders(supplierOrders);
	}

	@Override
	public void removeSupplierOrder(SupplierOrder supplierOrder) {
		ArrayList<SupplierOrder> supplierOrders  = initialData.getSupplierOrders();
		for(int i=0; i<supplierOrders.size(); i++) {
			if(supplierOrders.get(i).equals(supplierOrder))
				supplierOrders.remove(i);
		}
		initialData.setSupplierOrders(supplierOrders);
	}
	
}
