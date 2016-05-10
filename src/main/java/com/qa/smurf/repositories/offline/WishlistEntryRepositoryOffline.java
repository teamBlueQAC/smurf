package com.qa.smurf.repositories.offline;

/**
 * Author - Omar
 */

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.entities.WishListEntry;
import com.qa.smurf.repositories.WishListEntryRepository;

@Default
@Stateless
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
	public WishListEntry findByID(long id) {
		for (WishListEntry w: initialData.getWishListEntries()) {
			if (w.getId() == id) {
				return w;

			}
		}
		return null;
	}
	
	@Override
	public ArrayList<WishListEntry> getWishListEntries() {
		return initialData.getWishListEntries();
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

	@Override
	public WishListEntry findByProductAndUser(Product product, User user) {
		ArrayList<WishListEntry> wishListEntries = initialData.getWishListEntries();
		WishListEntry foundEntry = null;
		for (int i = 0; i < wishListEntries.size(); i++){
			if(wishListEntries.get(i).getProduct().equals(product) &&
					wishListEntries.get(i).getUser().equals(user)){
				foundEntry = wishListEntries.get(i);
				break;
			}
		}
		
		return foundEntry;
	}
	
	@Override
	public ArrayList<WishListEntry> findByUser(User user) {
		ArrayList<WishListEntry> wishListEntries = initialData.getWishListEntries();
		ArrayList<WishListEntry> foundEntries = new ArrayList<WishListEntry>();
		for (int i = 0; i < wishListEntries.size(); i++){
			if(wishListEntries.get(i).getUser().equals(user)){
				foundEntries.add(wishListEntries.get(i));
			}
		}
		
		return foundEntries;
	}
}
