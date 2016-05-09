package com.qa.smurf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EmployeeUser")
public class EmployeeUser {

	@Id
	@Column(name = "EMPLOYEEUSER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", nullable = false, length = 255)
	@NotNull
	private String name;
	public EmployeeUser( String name) {
		this.name = name;
	}

	public long getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
