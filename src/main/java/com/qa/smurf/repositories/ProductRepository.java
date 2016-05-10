/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.Product;

public interface ProductRepository {

	public void persistProduct(Product pr);

	public void persistProducts(List<Product> pr);

	public Product findByID(long id);
	
	public Product findByName(String name);

	public ArrayList<Product> getProducts();

	public void updateProduct(Product pr);

	public void removeProduct(Product pr);
}