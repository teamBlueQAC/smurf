package com.qa.smurf.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 
 * Created by Sam and Elliot
 *
 */

@Entity
@Table(name = "User")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME", length = 255)
	private String name;

	@Column(name = "PASSWORD", nullable = false, length = 64)
	@NotNull
	private String password;

	@Column(name = "EMAIL", length = 255, nullable = false)
	@NotNull
	private String email;

	@Column(name = "PHONENUMBER", length = 16)
	private String phone;

	@Temporal(TemporalType.DATE)
	@Column(name = "LASTLOGIN")
	private Date lastLogin;

	@Column(name = "ISACTIVE", nullable = false)
	@NotNull
	private boolean isActivate;

	@JoinColumns({ @JoinColumn(name = "LINE1"), @JoinColumn(name = "POSTCODE") })
	private Address address;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATECREATED", nullable = false)
	@NotNull
	private Date created;

	public User(int id, String name, String password, String email, String phoneNumber, Date lastLogin,
			boolean isActive, Address address, Date dateCreated) {
		this.id= id;
		this.name=name;
		this.password=password;
		this.email= email;
		this.phone = phoneNumber;
		this.lastLogin = lastLogin;
		this.isActivate = isActive;
		this.address = address;
		this.created = dateCreated;
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
