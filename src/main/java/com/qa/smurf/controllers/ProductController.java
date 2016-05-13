package com.qa.smurf.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.qa.smurf.entities.Product;
import com.qa.smurf.service.ProductService;

@Named("product")
@Path("product")
@RequestScoped
public class ProductController {
	@Inject	private ProductService productService;
	@Inject CurrentProduct product;
	private List<Product> products;
	private String productType;
	
	@PostConstruct
	public void init() {
		products = productService.getProducts();
	}
	
	public Product findById(long id){
		product.setProduct(productService.findById(id));
		return product.getProduct();
	}
	
	public String getProductById(long productId) {
		product.setProduct(productService.findById(productId));
		return "product";
	}
	
	public Product findByName(String name){
		product.setProduct(productService.findByName(name));
		return product.getProduct();
	} 
	
	public Product findByType(){
		product.setProduct(productService.findByType(productType));
		return product.getProduct();
	}
	
	@GET
	public Product getProduct(){
		return product.getProduct();
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
		return productService.productPriceTo2DP(product.getProduct());
	}

	public String getProductType() {
		return productType;
	}

	public void changeType(String productType) {
		System.out.println("--Changing type to " + productType);
		this.productType = productType;
	}
}	