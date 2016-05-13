package com.qa.smurf.controllers;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Order;
import com.qa.smurf.service.OrderService;

@Named(value = "myorders")
@SessionScoped
public class MyOrdersController {
	@Inject	private OrderService orderService;
	@Inject private CurrentUser currentUser;
	private List<Order> orders;
	
	public List<Order> getOrders() {
		orders = orderService.getPaidOrders(currentUser.getUserId());
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
