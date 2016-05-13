package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.util.ProductType;

@Default
@Stateless
public class ProductRepositoryOffline implements ProductRepository {

	@Inject
	private InitialData initialData;

	@Override
	public void persistProduct(Product pr) {
		initialData.addProduct(pr);

	}

	@Override
	public void persistProducts(List<Product> pr) {
		for (Product prod : pr) {
			persistProduct(prod);
		} // method overloading
	}

	@Override
	public Product findByID(long id) {
		ArrayList<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				return products.get(i);
			}
		}
		return null;

	}

	@Override
	public Product findByName(String name) {
		ArrayList<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(name)) {
				return products.get(i);
			}
		}
		return null;

	}

	@Override
	public ArrayList<Product> getProducts() {
		return initialData.getProducts();

	}

	@Override
	public void updateProduct(Product pr) {
		ArrayList<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == pr.getId()) {
				products.set(i, pr);
				break;
			}
		}
	}

	@Override
	public void removeProduct(Product pr) {
		ArrayList<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).equals(pr)) {
				products.remove(i);
				break;
			}
		}

	}

	@Override
	public ArrayList<Product> findByType(ProductType productType) {
		if(productType == null){
			return getProducts();
		}
		else{
			return compileProductListByType(productType);
		}
	}
	
	private ArrayList<Product> compileProductListByType(ProductType productType) {
		ArrayList<Product> foundProducts = new ArrayList<Product>();
		ArrayList<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductType().equals(productType)) {
				foundProducts.add(products.get(i));
			}
		}
		return foundProducts;
	}
}
