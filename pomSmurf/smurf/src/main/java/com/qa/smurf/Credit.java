/* Made By Dean + Nabs */
package com.qa.smurf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Credit")
public class Credit {

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "AMOUNT_REMAINING")
	private Double amountRemaining;

	@Column(name = "QUARTER")
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
