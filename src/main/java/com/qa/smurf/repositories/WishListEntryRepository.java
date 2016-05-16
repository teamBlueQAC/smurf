/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.entities.WishListEntry;

public interface WishListEntryRepository {

	public void persistWishListEntry(WishListEntry w);

	public void persistWishListEntries(List<WishListEntry> w);

	public WishListEntry findByProductAndUser(Product product, User user);

	public ArrayList<WishListEntry> getWishListEntries();

	public void removeWishListEntry(WishListEntry w);

	public ArrayList<WishListEntry> findByUser(User user);

}
