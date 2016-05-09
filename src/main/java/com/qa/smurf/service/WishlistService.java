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
		ArrayList<WishListEntry> wishList = wishlistRepository.getWishListEntries(userId);
		boolean itemFound = false;
		for (WishListEntry w : wishList) {
			if (!itemFound) {
				Product p = w.getProduct();
				if (p.getId() == productId) {
					itemFound = true;
					wishlistRepository.removeWishListEntry(w);
				}
			}
		}

	}

	public void addToWishlist(long productId, long userId) {
		ArrayList<WishListEntry> wishList = wishlistRepository.getWishListEntries(userId);
		boolean itemFound = false;
		for (WishListEntry w : wishList) {
			if (!itemFound) {
				Product p = w.getProduct();
				if (p.getId() == productId) {
					itemFound = true;
				}
			}
		}
		if (!itemFound) {
			Product p = productRepository.findByID(productId);
			WishListEntry w1 = new WishListEntry(p, new Date(), userRepository.findByID(userId));
		}

	}

	public ArrayList<WishListEntry> getWishListEntries(long userId) {
		ArrayList<WishListEntry> wishList = wishlistRepository.getWishListEntries(userId);
		return wishList;
	}

}
