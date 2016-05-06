package com.qa.smurf.repositories.offline;

/**  
* Author - Tom  
*/

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.util.OrderStatus;

@Default
@Stateless
public class OrderRepositoryOffline implements OrderRepository {
	@Inject
	private InitialData initialData;

	@Override
	public void persistOrder(Order o) {
		initialData.addOrder(o);
	}

	@Override
	public void persistOrders(ArrayList<Order> o) {
		initialData.setOrders(o);
	}

	@Override
	public Order findByID(long id) {
		ArrayList<Order> orders = initialData.getOrders();
		Order order = null;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId() == id) {
				order = orders.get(i);
				break;
			}
		}
		return order;
	}

	@Override
	public ArrayList<Order> findByOrderStatus(OrderStatus orderStatus) {
		ArrayList<Order> orders = initialData.getOrders();
		ArrayList<Order> foundOrders = new ArrayList<Order>();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderStatus().equals(orderStatus)) {
				foundOrders.add(orders.get(i));
			}
		}
		return foundOrders;
	}

	@Override
	public ArrayList<Order> findByUser(User user) {
		ArrayList<Order> orders = initialData.getOrders();
		ArrayList<Order> foundOrders = new ArrayList<Order>();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getUser().equals(user)) {
				foundOrders.add(orders.get(i));
			}
		}
		return foundOrders;
	}

	@Override
	public ArrayList<Order> getOrders() {
		return initialData.getOrders();
	}

	@Override
	public void updateOrder(Order order) {
		ArrayList<Order> orders = initialData.getOrders();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId() == order.getId()){
				orders.set(i, order);
				break;
			}
		}
	}

	@Override
	public void removeOrder(Order order) {
		ArrayList<Order> orders = initialData.getOrders();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).equals(order)){
				orders.remove(i);
				break;
			}
		}

	}

	//@Override
	//public Order findMostRecentUnPaidOrder(long userId) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public Order getBasketOrder(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getUsersPendingOrder(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findByUserAndStatus(long userId, OrderStatus pending) {
		// TODO Auto-generated method stub
		return null;
	}

}
