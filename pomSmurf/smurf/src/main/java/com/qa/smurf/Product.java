package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NAME", length = 255)
	@Size(min = 2, max = 255)
	private String name;
	
	@Column(name = "SERIAL", nullable= false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String serial;
	
	@Column(name = "COLOUR", length = 20)
	@Size(min = 2, max = 20)
	private String colour;
	
	@Column(name = "PRICE", nullable= false, length = 12)
	@NotNull
	private Double price;
	
	@Column(name = "DISCONTINUED", nullable= false)
	@NotNull
	private boolean discountinued;
	
	@Column(name = "PICTURELOC", length = 510)
	@Size(min = 2, max = 510)
	private String pictureLoc;
	
	@Column(name = "QUANTITYAVAILABLE", length = 20)
	@Size(min = 2, max = 20)
	private int quantityAvailable;
	
	@ManyToOne
	@JoinColumn(name="TYPE_ID", nullable= false)
	@NotNull
	private ProductType productType;
	
	@Column(name = "DESCRIPTION", nullable= false, length = 510)
	@NotNull
	@Size(min = 2, max = 510)
	private String description;
	
	@Column(name = "REORDERTHRESHOLD", length = 20)
	private int reorderThreshold;
	
	@Column(name = "REORDEREDAMOUNT", length = 20)
	private int reorderedAmount;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isDiscountinued() {
		return discountinued;
	}
	public void setDiscountinued(boolean discountinued) {
		this.discountinued = discountinued;
	}
	public String getPictureLoc() {
		return pictureLoc;
	}
	public void setPictureLoc(String pictureLoc) {
		this.pictureLoc = pictureLoc;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReorderThreshold() {
		return reorderThreshold;
	}
	public void setReorderThreshold(int reorderThreshold) {
		this.reorderThreshold = reorderThreshold;
	}
	public int getReorderedAmount() {
		return reorderedAmount;
	}
	public void setReorderedAmount(int reorderedAmount) {
		this.reorderedAmount = reorderedAmount;
	}
	
	
}
