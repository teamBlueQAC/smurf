/* Made By Dean + Nabs */
package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AccountType")
public class AccountType {

	@Id
	@Column(name = "ACCOUNTTYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME", length = 255)
	private String name;

	@ManyToOne
	@JoinTable(name = "EMPLOYEEUSER_ID")
	private EmployeeUser employeeUser;
	
	public EmployeeUser getEmployeeUser() {
		return employeeUser;
	}
	public void setEmployeeUser(EmployeeUser employeeUser) {
		this.employeeUser = employeeUser;
	}

	public int getId() {
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