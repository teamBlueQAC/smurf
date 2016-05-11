package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Product;

/*Author: willseaford*/
public interface LineItemsRepository {

	public void persistLineItems(LineItems lineitems);

	public void persistLineItems(List<LineItems> lineitems);

	public LineItems findByCompositeKey(Order order, Product product);

	public ArrayList<LineItems> findByProduct(Product product);

	public ArrayList<LineItems> getLineItems();

	public LineItems readLineItems(LineItems p);

	public void removeLineItem(LineItems lineItem);

}
