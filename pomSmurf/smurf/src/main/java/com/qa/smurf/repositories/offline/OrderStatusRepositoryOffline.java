package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.repositories.OrderStatusRepository;
import com.qa.smurf.util.OrderStatus;

/**  
* Author - Tom  
*/

public class OrderStatusRepositoryOffline 
implements OrderStatusRepository {
	@Inject
	private InitialData initialData;

	@Override
	public void persistOrderStatus(OrderStatus os) {
		initialData.addOrderStatus(os);
	}

	@Override
	public void persistOrderStatuses(ArrayList<OrderStatus> os) {
		initialData.setOrderStatuses(os);
	}

	@Override
	public OrderStatus findByID(long ID) {
		ArrayList<OrderStatus> orderStatuses = initialData.getOrderStatuses();
		OrderStatus orderStatus = null;
		for(int i = 0; i < orderStatuses.size(); i++) {
			if(orderStatuses.get(i).getId() == ID){
				orderStatus = orderStatuses.get(i);
				break;
			}
		}
		return orderStatus;
	}

	@Override
	public OrderStatus findByName(String name) {
		ArrayList<OrderStatus> orderStatuses = initialData.getOrderStatuses();
		OrderStatus orderStatus = null;
		for(int i = 0; i < orderStatuses.size(); i++) {
			if(orderStatuses.get(i).getName().equals(name)){
				orderStatus = orderStatuses.get(i);
				break;
			}
		}
		return orderStatus;
	}

	@Override
	public ArrayList<OrderStatus> getOrderStatuses() {
		return initialData.getOrderStatuses();
	}

	@Override
	public void updateOrderStatus(OrderStatus orderStatus) {
		ArrayList<OrderStatus> orderStatuses = initialData.getOrderStatuses();
		for(int i=0; i<orderStatuses.size(); i++) {
			if(orderStatuses.get(i).getId() == orderStatus.getId())
				orderStatuses.set(i, orderStatus);
		}
		initialData.setOrderStatuses(orderStatuses);
	}

	@Override
	public void removeOrderStatus(OrderStatus orderStatus) {
		ArrayList<OrderStatus> orderStatuses = initialData.getOrderStatuses();
		for(int i=0; i<orderStatuses.size(); i++) {
			if(orderStatuses.get(i).equals(orderStatus))
				orderStatuses.remove(i);
		}
		initialData.setOrderStatuses(orderStatuses);
	}

}