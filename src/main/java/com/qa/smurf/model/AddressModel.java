package com.qa.smurf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressModel {
	
	@Id
	public String postcode;
	
	public String address1;
	
	public String address2;
	
	public String address3;	

}
