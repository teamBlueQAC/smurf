package com.qa.smurf.repositories;
/**  
* Author - Tom  
*/  

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.User;
import com.qa.smurf.util.OrderStatus;

public interface OrderRepository {
	public void persistOrder(Order o);
	public void persistOrders(
			List<Order> o);
	
	public Order findByID(long id);
	public ArrayList<Order> findByOrderStatus(OrderStatus orderStatus);
	public ArrayList<Order> findByUser(User user);
	public ArrayList<Order> getOrders();
	
	public void updateOrder(Order o);
	
	public void removeOrder(Order o);
	
}
