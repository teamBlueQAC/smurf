package com.qa.smurf;

public class Catagories {
	
	private long id;
	private String name;
	
	public long getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setID(long newID){
		this.id = newID;
	}

	public void setName(String n){
		this.name = n;
	}
}
