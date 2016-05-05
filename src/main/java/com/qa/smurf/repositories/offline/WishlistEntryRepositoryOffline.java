package com.qa.smurf.repositories.offline;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Address;
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
	public void persistWishListEntrys(List<WishListEntry> wishListEntries) {
		for (WishListEntry w: wishListEntries) {
			initialData.addWishListEntry(w);
		}
	}

	@Override
	public WishListEntry findByID(long id) {
		for (WishListEntry w: initialData.WishListEntries()) {
			if (w.getId() == id) {
				return w;
			}
		}
		return null;
	}

	@Override
	public ArrayList<WishListEntry> getWishListEntrys() {
		return initialData.getWishListEntries();
	}

	@Override
	public void updateWishListEntry(WishListEntry w) {
		
	}

	@Override
	public void removeWishListEntry(WishListEntry w) {
		
	}
}
