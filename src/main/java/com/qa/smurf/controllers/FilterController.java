package com.qa.smurf.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "filter")
@SessionScoped
public class FilterController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productType;
	private String productID;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		System.out.println("--Changing type to " + productType);
		this.productType = productType;
	}

	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		System.out.println("--Changing ID to " + productID);
		this.productID = productID;
	}
	
	
	
	
	
	
}
