package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column( name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "NAME",nullable = false, length = 255)
	@NotNull
	@Size(min = 1, max = 255)
	private String name;
	
	@Column(name = "PASSWORD", nullable = false, length = 64 )
	@NotNull
	@Size(min = 1, max = 64)
	private String password;
	
	@Column (name = "EMAIL", nullable = false, length = 255)
	@NotNull
	@Size(min = 1, max = 255)
	private String email;
	
	@Column (name = "PHONENUMBER", length = 16)
	@NotNull
	@Size(min = 1, max = 16)
	private String phone;

	@Temporal(TemporalType.DATE)
	@Column (name = "LASTLOGIN", length = 10)
	private String lastLogin;
	
	@Column (name = "ISACTIVE", columnDefinition="Boolean default ='false'", nullable=false)
	@NotNull
	private boolean isActivate;
	
	@JoinColumns({ @JoinColumn(name = "LINE1"),
		@JoinColumn(name = "POSTCODE")})
	private Address address;
	

	@Temporal(TemporalType.DATE)
	@Column (name = "DATECREATED", length = 10)
	private String created;
	
	@ManyToOne
	@JoinColumn (name= "ACCOUNTTYPE_ID", nullable = false )
	@NotNull
	private int accountTypeID;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isActivate() {
		return isActivate;
	}

	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getAccountTypeID() {
		return accountTypeID;
	}

	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	

	
}
