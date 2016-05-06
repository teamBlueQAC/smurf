/* Made By Dean + Nabs */
package com.qa.smurf.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qa.smurf.entities.EmployeeUser;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;

@Entity
@Table(name = "AccountType")
public class AccountType {

	@Id
	@Column(name = "ACCOUNTTYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME", length = 255)
	private String name;

	public AccountType(int id, String name) {

	}

	@ManyToOne
	@JoinTable(name = "EMPLOYEEUSER_ID")
	@NotNull
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

	public Payment getUsersPayment(long userId) {
		// PLZ FIX
		return null;
	}

	public Order getUsersOrder(long userId) {
		// PLZ FIX
		return null;
	}

	public User getCustomerDetails(long userId) {
		// PLZ FIX
		return null;
	}

	public void updatePersonal(User user) {
		// PLZ FIX
		
	}

	public void updatePayment(Payment payment) {
		// PLZ FIX
		
	}
}
