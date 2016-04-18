package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;
/*Author: willseaford*/
public interface LineItemsRepository {

	public void persistLineItems ();
	public void persistLineItems (List<LineItems> payments);
	
	public LineItems findByID(long id);

	public ArrayList<LineItems> getLineItems();
	
	public LineItems readLineItems(LineItems p);

}
