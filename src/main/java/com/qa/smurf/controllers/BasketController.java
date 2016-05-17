package com.qa.smurf.controllers;

import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.User;
import com.qa.smurf.service.OrderService;
import com.qa.smurf.service.WishlistService;

/**
 * 
 * @author Nathan Orme
 * 
 *         Controller to handle all of the Basket operations for the system
 *
 */
@Named(value = "basket")
@SessionScoped
public class BasketController {
	@Inject	private OrderService orderService;
	@Inject	private CurrentUser currentUser;
	@Inject	private WishlistService wishlistService;
	private User user;
	private Order order;
	private List<LineItems> lineItems;

	public String removeProductFromBasket(long productId) {
		if(currentUser.getUserId()!=-1){
			orderService.removeFromBasket(productId, currentUser.getUserId());
		}
		return "basket";
	}

	public String updateQuantity() {
		orderService.updateQuantity(order, currentUser.getUserId());

		return "basket";
	}

	public String clearBasket() {
		orderService.clearBasket(currentUser.getUserId());
		return "basket";
	}


	public String addToBasket(long productId) {
		long userId = -1;
		if (currentUser.getUsername() != null){
			userId = currentUser.getUserId();
			orderService.addToBasket(productId, userId);
			wishlistService.removeFromWishlist(productId, userId);
			return "basket";
		} else {
			System.out.println("User not logged in");
			return "product";
		}
	}
	
	public void addToBasketFromCatalogue(long productId) {
		long userId = -1;
		if (currentUser.getUsername() != null){
			userId = currentUser.getUserId();
			orderService.addToBasket(productId, userId);
			wishlistService.removeFromWishlist(productId, userId);
		} else {
			System.out.println("User not logged in");
		}
	}

	public void getLineItems(Order order) {
		orderService.getLineItems(order, currentUser.getUserId());
	}

	public String placeOrder() {
		orderService.placeOrder(orderService.getUsersPendingOrder(currentUser.getUserId()), currentUser.getUserId());
		return "payment";
	}

	public User getUser() {
		user  = orderService.getCurrentUser(currentUser.getUserId());
		return user;
	}

	/*public void setUser(User user) {
		this.user = user;
	}*/

	public String getTotalPrice() {
		return String.format("%.2f", orderService.calcOrderTotalPending(currentUser.getUserId()));
	}

	public Order getOrder() {
		order  = orderService.getUsersPendingOrder(currentUser.getUserId());
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<LineItems> getLineItems() {
		lineItems = order.getLineItem();
		return lineItems;
	}

	public void setLineItems(List<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

}
