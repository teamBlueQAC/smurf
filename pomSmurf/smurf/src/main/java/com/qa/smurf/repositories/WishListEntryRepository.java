/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.WishListEntry;

public interface WishListEntryRepository {
	public void persistWishListEntry(WishListEntry w);

	public void persistWishListEntrys(List<WishListEntry> w);

	public WishListEntry findByID(long id);

	public ArrayList<WishListEntry> getWishListEntrys();

	public void updateWishListEntry(WishListEntry w);

	public void removeWishListEntry(WishListEntry w);

}
