package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProdSup")
public class ProdSup {

	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID")
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@Column(name = "cost", length = 12)
	private double cost;

	public Supplier getSupplier() {
		return supplier;
	}

	public Product getProduct() {
		return product;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
