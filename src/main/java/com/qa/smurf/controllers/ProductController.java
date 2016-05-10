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
}	




