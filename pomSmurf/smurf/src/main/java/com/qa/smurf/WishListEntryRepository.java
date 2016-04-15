/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface WishListEntryRepository {
	public void persistWishListEntry(WishListEntry w);

	public void persistWishListEntrys(List<WishListEntry> w);

	public WishListEntry findByID(long id);

	public ArrayList<WishListEntry> getWishListEntrys();

	public void updateWishListEntry(WishListEntry w);

	public void removeWishListEntry(WishListEntry w);

}
