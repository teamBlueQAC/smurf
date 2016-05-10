package com.qa.smurf.controllers;

import java.util.List;

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
	private List<Product> products = productService.getProducts();
	
	public Product findById(long id){
		this.product = productService.findById(id);
		return product;
	}
	
	public Product findByName(String name){
		this.product = productService.findByName(name);
		return product;
	} 
	
	public Product getProduct(){
		return product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}	




