package com.qa.smurf.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "ProdCat")
public class ProdCat {
	@ManyToOne
	@JoinColumn(name ="CATEGORY_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name ="PRODUCT_ID")
	private Product product;
	
	public Category getCategory(){
		return category;
	}
	public Product getProduct(){
		return product;
	}
	
}
