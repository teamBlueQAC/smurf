package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.LineItemsRepository;

@Default
@Stateless
public class LineItemsRepositoryOffline implements LineItemsRepository {

	@Inject
	private InitialData initialData;

	@Override
	public void persistLineItems(LineItems lineitems) {
		initialData.addLineItems(lineitems);

	}

	public void persistLineItems(List<LineItems> lineitems) {
		for (LineItems l : lineitems) {
			initialData.addLineItems(l);
		}

	}

	public LineItems findByCompositeKey(Order order, Product product) {
		for (LineItems l : initialData.getLineItems()) {
			if (l.getOrder().equals(order) && l.getProduct().equals(product)) {
				return l;
			}
		}

		return null;
	}

	public ArrayList<LineItems> findByProduct(Product product) {
		ArrayList<LineItems> temp = new ArrayList<LineItems>();
		for (LineItems l : initialData.getLineItems()) {
			if (l.getProduct().equals(product)) {
				temp.add(l);
			}
		}

		return temp;
	}

	public ArrayList<LineItems> getLineItems() {
		ArrayList<LineItems> lineitems = new ArrayList<LineItems>();
		lineitems = initialData.getLineItems();
		return lineitems;
	}

	public LineItems readLineItems(LineItems p) {
		ArrayList<LineItems> lineitems = new ArrayList<LineItems>();
		lineitems = initialData.getLineItems();
		for (int i = 0; i < lineitems.size(); i++) {
			if (lineitems.get(i).equals(p)) {
				return lineitems.get(i);
			}
		}
		return null;
	}
	
	@Override
	public void removeLineItem(LineItems lineItem) {
		ArrayList<LineItems> lineItems = initialData.getLineItems();
		for (int i = 0; i < lineItems.size(); i++) {
			if (lineItems.get(i).equals(lineItem)){
				lineItems.remove(i);
			}
		}
		initialData.setLineItems(lineItems);
	}

}
