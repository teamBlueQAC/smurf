/* Made By Dean + Nabs */
package com.qa.smurf.entities;

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
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "AMOUNT", nullable = false)
	@NotNull
	private Double amount;

	@Column(name = "AMOUNT_REMAINING", nullable = false)
	@NotNull
	private Double amountRemaining;

	public Credit(User user, double amount, double amountRemaining) {
		this.user = user;
		this.amount = amount;
		this.amountRemaining = amountRemaining;
	}

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
}
