package com.qa.smurf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryModel {
	
	@Id
	@GeneratedValue
	private long id;

}
