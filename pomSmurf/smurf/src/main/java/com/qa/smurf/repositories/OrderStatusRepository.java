package com.qa.smurf.repositories;
/**  
* Author - Tom  
*/  

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.util.OrderStatus;

public interface OrderStatusRepository {
	public void persistOrderStatus(OrderStatus os);
	public void persistOrderStatuses(
			List<OrderStatus> os);
	
	public OrderStatus findByID(long ID);
	public OrderStatus findByName(String name);
	public ArrayList<OrderStatus> getOrderStatuses();
	
	public void updateOrderStatus(OrderStatus os);
	
	public void removeOrderStatus(OrderStatus os);
}