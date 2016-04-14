package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Credit")
public class Credit {

	@Id
	@OneToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	@NotNull
	private User user;

	@Column(name = "AMOUNT", length = 255)
	private Double amount;

	@Column(name = "AMOUNT_REMAINING", length = 255)
	private Double amountRemaining;

	@Column(name = "QUARTER", length = 255)
	private int quarter;

	public User getUser() {
		return user;
	}

	public void setUserID(User userID) {
		this.user = userID;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(Double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

}
