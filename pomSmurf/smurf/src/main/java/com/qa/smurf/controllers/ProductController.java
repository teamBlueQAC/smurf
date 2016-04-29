package com.qa.smurf.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Product;
import com.qa.smurf.service.ProductService;

@Named(value = "product")
@RequestScoped
public class ProductController {
	@Inject
	private ProductService productService;
	private Product product;
	
	public String findProductById(long id){
		this.product = productService.findByProductId(id);
		return "product";
	}
	
	public Product getProduct(Product product){
		return this.product;
	}
}	




