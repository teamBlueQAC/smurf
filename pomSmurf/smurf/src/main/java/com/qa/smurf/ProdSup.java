package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * Class modelling the Product_Supplier
 * 
 * 
 * */
@Entity
@Table (name = "ProdSup")
public class ProdSup {

	@Id
	@Column (name = "supplierID", length = 20)
	@GeneratedValue (
			strategy = GenerationType.IDENTITY)
	private long supplierID;
	
	@ManyToMany
	
	@JoinTable(name = "prodID_fk")
	@Column(length = 20)
	private long prodID;
	
	@Column (name = "cost", length = 12 )
	private double cost;
	
	
	public long getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public long getProdID() {
		return prodID;
	}
	public void setProdID(int pID) {
		this.prodID = pID;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
