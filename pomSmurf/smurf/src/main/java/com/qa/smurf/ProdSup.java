package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Class modelling the Product_Supplier

@Entity
@Table (name = "ProdSup")
public class ProdSup {

	@ManyToOne
	@JoinColumn(name ="SUPPLIER_ID", nullable= false)
	@NotNull
	private Supplier supplier;
	@ManyToOne
	@JoinColumn(name ="PRODUCT_ID", nullable= false)
	@NotNull
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
