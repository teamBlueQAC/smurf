package com.qa.smurf.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.util.ProductType;

@Stateless
public class ProductService {
	@Inject
	private ProductRepository productRepository;
	@Inject
	private InitialData initialData;

	public Product findById(long id) {
		return productRepository.findByID(id);
	}
	
	public Product findByName(String name){
		return productRepository.findByName(name);
	}

	public List<Product> getProducts() {
		return initialData.getProducts();
	}

	public String productPriceTo2DP(Product product) {
		return String.format("%.2f", product.getPrice());
	}

	public Product findByType(String productType) {
		for (ProductType p : ProductType.values()) {
			if(p.toString().equalsIgnoreCase(productType))
				return productRepository.findByType(p);
		}
		return null;
	}
}