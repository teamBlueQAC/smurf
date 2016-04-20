package com.qa.smurf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountTypeModel {
	
	@Id
	@GeneratedValue
	public long id;
	
	@Column(length = 255)
	public String name;

}
