package com.pers.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class PhoneNumber {

	@EmbeddedId
	private NumberPk numberpk;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(short countryCode, Long number, Customer customer) {
		numberpk = new NumberPk(countryCode, number);
		this.customer=customer;
	}

	public NumberPk getNumberpk() {
		return numberpk;
	}

	public void setNumberpk(NumberPk numberpk) {
		this.numberpk = numberpk;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
