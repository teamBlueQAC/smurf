package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeUser")
public class EmployeeUser {

	@Id
	@Column(name = "EMPLOYEEUSER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "ACCOUNTTYPE_ID")
	private AccountType accountType;

	@Column(name = "NAME", length = 255)
	private String name;

	public long getID() {
		return id;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public String getName() {
		return name;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setName(String name) {
		this.name = name;
	}
}
