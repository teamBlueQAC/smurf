package com.qa.smurf.service;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.entities.WishListEntry;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.repositories.UserRepository;
import com.qa.smurf.repositories.WishListEntryRepository;

@Stateless
public class WishlistService {
	@Inject private UserRepository userRepository;
	@Inject private WishListEntryRepository wishlistRepository;
	@Inject private ProductRepository productRepository;
	@Inject private OrderService orderService;

	public User getCurrentUser(long userId) {
		return userRepository.findByID(userId);
	}

	public void removeFromWishlist(long productId, long userId) {
		WishListEntry wishlistEntry = wishlistRepository.findByProductAndUser(productRepository.findByID(productId), userRepository.findByID(userId));
		if(wishlistEntry!=null){
			wishlistRepository.removeWishListEntry(wishlistEntry);
		}

	}

	public String addToBasketFromWishlist(long productId, long userId){
		removeFromWishlist(productId, userId);
		orderService.addToBasket(productId, userId);
		return "basket";
	}

	public void addToWishlist(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		WishListEntry wishlistEntry = wishlistRepository.findByProductAndUser(product, userRepository.findByID(userId));
		if(wishlistEntry!=null){
			System.out.println("Item already exists in wishlist");
		} else {
			WishListEntry newWishlistEntry = new WishListEntry(product, new Date(), userRepository.findByID(userId));
			wishlistRepository.persistWishListEntry(newWishlistEntry);
		}

	}

	public ArrayList<WishListEntry> getWishListEntries(long userId) {
		ArrayList<WishListEntry> wishList = wishlistRepository.findByUser(userRepository.findByID(userId));
		return wishList;
	}

	public boolean checkOnWishlist(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		WishListEntry wishlistEntry = wishlistRepository.findByProductAndUser(product, userRepository.findByID(userId));
		if(wishlistEntry != null){
			return true;
		} else {
			return false;
		}
	}
}