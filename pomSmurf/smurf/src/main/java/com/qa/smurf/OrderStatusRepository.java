/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface OrderStatusRepository {

	public void persistOrderStatus(OrderStatus os);

	public void persistOrderStatuss(List<OrderStatus> os);

	public OrderStatus findByID(long id);

	public ArrayList<OrderStatus> getOrderStatuss();

	public void updateOrderStatus(OrderStatus os);

}
