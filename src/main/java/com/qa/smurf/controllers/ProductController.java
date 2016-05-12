package com.qa.smurf.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.smurf.entities.Product;
import com.qa.smurf.service.ProductService;

@Named("product")
@Path("product")
@RequestScoped
public class ProductController {
	@Inject	
	private ProductService productService;
	private Product product;
	private List<Product> products;
	private String productType;
	
	@PostConstruct
	public void init() {
		products = productService.getProducts();
		product = products.get(3);
	}
	
	public Product findById(long id){
		this.product = productService.findById(id);
		return product;
	}
	
	@GET
	@Path("{productId}")
	public String getProductById(@PathParam("productId") long productId) {
		this.product = productService.findById(productId);
		return "product";
	}
	
	public Product findByName(String name){
		this.product = productService.findByName(name);
		return product;
	} 
	
	public Product findByType(){
		this.product = productService.findByType(productType);
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
	
	public String getProductPrice(Product product){
		return productService.productPriceTo2DP(product);
	}
	public String getProductPrice(){
		return productService.productPriceTo2DP(this.product);
	}

	public String getProductType() {
		return productType;
	}

	public void changeType(String productType) {
		System.out.println("--Changing type to " + productType);
		this.productType = productType;
	}
}	