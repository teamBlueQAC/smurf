package com.qa.smurf.controllers;

import java.util.ArrayList;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.User;
import com.qa.smurf.entities.WishListEntry;
import com.qa.smurf.service.WishlistService;

@Named(value = "wishlist")
@RequestScoped
public class WishListController {
	@Inject private WishlistService wishlistService;
	@Inject	private CurrentUser currentUser;


	private User user;
	private ArrayList<WishListEntry> wishListEntries;

	public void addToWishlist(long productId) {
		if(wishlistService.getCurrentUser(currentUser.getUserId())!= null){
			wishlistService.addToWishlist(productId, currentUser.getUserId());
		}
	}

	public String removeFromWishlist(long productId) {
		wishlistService.removeFromWishlist(productId, currentUser.getUserId());
		return "wishlist";
	}

	public String addToBasket(long productId){
		return wishlistService.addToBasketFromWishlist(productId, currentUser.getUserId());
	}

	public User getUser() {
		user = wishlistService.getCurrentUser(currentUser.getUserId());
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<WishListEntry> getWishListEntries() {
		wishListEntries = wishlistService.getWishListEntries(currentUser.getUserId());
		return wishListEntries;
	}

	public void setWishListEntries(ArrayList<WishListEntry> wishListEntries) {
		this.wishListEntries = wishListEntries;
	}
}

