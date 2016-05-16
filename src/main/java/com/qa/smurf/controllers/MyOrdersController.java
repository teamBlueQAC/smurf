package com.qa.smurf.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@PostConstruct
	public void init() {
		orders = orderService.getPaidOrders(currentUser.getUserId());
	}
	
	public BigDecimal getOrderTotal(Order order){
		BigDecimal bd = new BigDecimal(orderService.calculateOrderTotal(order));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

}
