/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;

import com.qa.smurf.entities.Category;
import com.qa.smurf.entities.ProdCat;
import com.qa.smurf.entities.Product;

public interface ProdCatRepository {

	public void persistProdCat(ProdCat prodCat);

	public void persistProdCats(ArrayList<ProdCat> prc);

	public ArrayList<Product> findByCategory(Category category);
	
	public ArrayList<Category> findByProduct(Product product);

	public ArrayList<ProdCat> getProdCats();

	public void removeProdCat(ProdCat prodCat);

}
