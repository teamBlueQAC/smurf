package com.qa.smurf.service;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.entities.WishListEntry;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.repositories.UserRepository;
import com.qa.smurf.repositories.WishListEntryRepository;

public class WishlistService {
	@Inject
	UserRepository userRepository;
	@Inject
	WishListEntryRepository wishlistRepository;
	@Inject
	ProductRepository productRepository;

	public User getCurrentUser(long userId) {
		return userRepository.findByID(userId);
	}

	public void removeFromWishlist(long productId, long userId) {
		WishListEntry wishlistEntry = wishlistRepository.findByProductAndUser(productRepository.findByID(productId), userRepository.findByID(userId));
		if(wishlistEntry!=null){
			System.out.println("Item already exists in wishlist");
		} else {
			wishlistRepository.removeWishListEntry(wishlistEntry);
		}

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

}
