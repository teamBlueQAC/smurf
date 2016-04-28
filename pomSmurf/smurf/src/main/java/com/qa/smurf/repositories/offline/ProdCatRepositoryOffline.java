package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Category;
import com.qa.smurf.entities.ProdCat;
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.ProdCatRepository;

public class ProdCatRepositoryOffline implements ProdCatRepository {
	@Inject
	private InitialData initialData;

	@Override
	public void persistProdCat(ProdCat prodCat) {
		initialData.addProdCat(prodCat);
	}

	@Override
	public void persistProdCats(ArrayList<ProdCat> prodCats) {
		initialData.setProdCats(prodCats);
	}

	@Override
	public ArrayList<Product> findByCategory(Category category) {
		ArrayList<ProdCat> prodCats = initialData.getProdCats();
		ArrayList<Product> foundProducts = new ArrayList<Product>();
		for (int i = 0; i < prodCats.size(); i++) {
			if (prodCats.get(i).getCategory().equals(category)) {
				foundProducts.add(prodCats.get(i).getProduct());
			}
		}
		return foundProducts;
	}

	@Override
	public ArrayList<Category> findByProduct(Product product) {
		ArrayList<ProdCat> prodCats = initialData.getProdCats();
		ArrayList<Category> foundCategories = new ArrayList<Category>();
		for (int i = 0; i < prodCats.size(); i++) {
			if (prodCats.get(i).getProduct().equals(product)) {
				foundCategories.add(prodCats.get(i).getCategory());
			}
		}
		return foundCategories;
	}

	@Override
	public ArrayList<ProdCat> getProdCats() {
		return initialData.getProdCats();
	}

	@Override
	public void removeProdCat(ProdCat prodCat) {
		ArrayList<ProdCat> prodCats = initialData.getProdCats();
		for (int i = 0; i < prodCats.size(); i++) {
			if (prodCats.get(i).equals(prodCat))
				prodCats.remove(i);
		}
		initialData.setProdCats(prodCats);
	}

}
