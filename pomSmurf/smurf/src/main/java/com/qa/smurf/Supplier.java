package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "SUPPLIER")
public class Supplier {
	
	@Id
	@Column (name ="SUPPLIER_ID")
	@GeneratedValue (
			strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name ="NAME",
			nullable = false, length = 255)
	@NotNull
	@Size (min = 1, max = 255)
	private String name;
	
	@JoinColumns({ @JoinColumn(name = "LINE1"),
						@JoinColumn(name = "POSTCODE")})
	private Address address;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	
}
