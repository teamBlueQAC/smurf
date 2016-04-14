package com.qa.smurf;

public class Product {

	private long id;
	private long name;
	private String serial;
	private String colour;
	private Double price;
	private boolean discountinued;
	private String pictureLoc;
	private int quantityAvailable;
	private long typeID;
	private String description;
	private int reorderThreshold;
	private int reorderedAmount;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getName() {
		return name;
	}
	public void setName(long name) {
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
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
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
