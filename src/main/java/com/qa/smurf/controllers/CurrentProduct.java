package com.qa.smurf.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qa.smurf.entities.Product;

@Named(value = "currentProduct")
@SessionScoped
public class CurrentProduct implements Serializable {
	
	private static final long serialVersionUID = 2647685390330337075L;
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
