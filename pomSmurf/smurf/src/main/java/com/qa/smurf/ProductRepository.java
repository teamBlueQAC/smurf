/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository {

	public void persistProduct(Product pr);

	public void persistProducts(List<Product> pr);

	public Product findByID(long id);

	public ArrayList<Product> getProducts();

	public void updateProduct(Product pr);

	public void removeProduct(Product pr);

}
