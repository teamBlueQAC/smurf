package com.qa.smurf;

public class ProdCat {
	private long catID;
	private long prodID;
	
	
	public long getCatID(){
		return catID;
	}
	
	public long getProdID(){
		return prodID;
	}
	
	public void setCatID(Long cID){
		this.catID = cID;
	}
	
	public void setProdID(Long pID){
		this.prodID = pID;
	}
}
