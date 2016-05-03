package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Product;
/*Author: willseaford*/
public interface LineItemsRepository {

	public void persistLineItems ();
	public void persistLineItems (List<LineItems> payments);
	
	public LineItems findByID(long id);
	
	public LineItems findByProduct(Product product);

	public ArrayList<LineItems> getLineItems();
	
	public LineItems readLineItems(LineItems p);

}
