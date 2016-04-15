/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {

	public void persistOrder(Order o);

	public void persistOrders(List<Order> o);

	public Order findByID(long id);

	public ArrayList<Order> getOrders();

	public void updateOrder(Order o);

}
