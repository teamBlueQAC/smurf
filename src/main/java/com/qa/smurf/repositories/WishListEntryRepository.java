/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.WishListEntry;

public interface WishListEntryRepository {

	public void persistWishListEntry(WishListEntry w);

	public void persistWishListEntries(List<WishListEntry> w);

	public WishListEntry findByProductAndUser(long productID, long userID);

	public ArrayList<WishListEntry> getWishListEntries();

	public void updateWishListEntry(WishListEntry w);

	public void removeWishListEntry(WishListEntry w);

}
