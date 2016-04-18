/* Made By Dean + Nabs */
package com.qa.smurf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@Column(name = "LINE1", length = 255, nullable = false)
	@NotNull
	private String line1;

	@Column(name = "LINE2", length = 255)
	private String line2;

	@Column(name = "LINE3", length = 255)
	private String line3;

	@Column(name = "LINE4", length = 255)
	private String line4;

	@Id
	@Column(name = "POSTCODE", length = 9, nullable = false)
	@NotNull
	private String postcode;

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getLine4() {
		return line4;
	}

	public void setLine4(String line4) {
		this.line4 = line4;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
