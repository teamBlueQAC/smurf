package com.qa.smurf.repositories.offline;

//import com.qa.smurf.entities;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.LineItemsRepository;

public class LineItemsOfflineRepository implements LineItemsRepository {

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

	public ArrayList<LineItems> findByCompositeKey(Order order, Product product) {
		ArrayList<LineItems> temp = ArrayList<LineItems>();
		try {
			for (LineItems l : initialData.getLineItems()) {
				if (l.getOrder().equals(order) && l.getProduct().equals(product)) {
					temp.add(l);
				}
			}
		} catch (ParseException pe) {
			System.err.println();
		}

		return temp;
	}

	public ArrayList<LineItems> findByProduct(Product product) {
		ArrayList<LineItems> temp = ArrayList<LineItems>();
		try {
			for (LineItems l : initialData.getLineItems()) {
				if (l.getProduct().equals(product)) {
					temp.add(l);
				}
			}
		} catch (ParseException pe) {
			System.err.println();
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

}
