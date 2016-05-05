package com.qa.smurf.repositories.offline;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.WishListEntry;
import com.qa.smurf.repositories.WishListEntryRepository;

public class WishlistEntryRepositoryOffline implements WishListEntryRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistWishListEntry(WishListEntry w) {
		initialData.addWishListEntry(w);
	}

	@Override
	public void persistWishListEntries(List<WishListEntry> wishListEntries) {
		for (WishListEntry w: wishListEntries) {
			initialData.addWishListEntry(w);
		}
	}
	
	@Override 
	public WishListEntry findByProductAndUser(long productID, long userID)
	{		
		for (WishListEntry wishListEntry: initialData.getWishListEntries()) {
			if ((wishListEntry.getUser().getId() == userID) && (wishListEntry.getProduct().getId() == productID)) {
				return wishListEntry;
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<WishListEntry> getWishListEntries() {
		return initialData.getWishListEntries();
	}

	@Override
	public void updateWishListEntry(WishListEntry w) {
		
	}

	@Override
	public void removeWishListEntry(WishListEntry wishListEntry) {
		ArrayList<WishListEntry> wishListEntries = initialData.getWishListEntries();
		for (int i = 0; i < wishListEntries.size(); i++) {
			if (wishListEntries.get(i).equals(wishListEntry))
				wishListEntries.remove(i);
		}
		initialData.setWishListEntries(wishListEntries);
	}
}
