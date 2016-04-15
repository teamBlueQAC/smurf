package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "OrderStatus")
public class OrderStatus {

	@Id

	@Column (name = "ORDERSTATUS_ID")
	@GeneratedValue (
			strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "NAME", nullable = false, length = 255)
	@NotNull
	@Size (min = 1, max = 255)
	private String name;
	
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
