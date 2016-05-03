package com.qa.smurf.service;

import javax.inject.Inject;

import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.ProductRepository;

public class ProductService {
	@Inject
	ProductRepository productRepository;

	public Product findByProductId(long id) {
		return productRepository.findByID(id);
	}

}
