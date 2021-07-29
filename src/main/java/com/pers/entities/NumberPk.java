package com.pers.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NumberPk implements Serializable {
	private short countryCode;
	private Long phNumber;
	
	public NumberPk() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countryCode;
		result = prime * result + ((phNumber == null) ? 0 : phNumber.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberPk other = (NumberPk) obj;
		if (countryCode != other.countryCode)
			return false;
		if (phNumber == null) {
			if (other.phNumber != null)
				return false;
		} else if (!phNumber.equals(other.phNumber))
			return false;
		return true;
	}



	public NumberPk(short countryCode, Long number) {
		super();
		this.countryCode = countryCode;
		this.phNumber = number;
	}
	public short getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(short countryCode) {
		this.countryCode = countryCode;
	}
	public Long getNumber() {
		return phNumber;
	}
	public void setNumber(Long number) {
		this.phNumber = number;
	}
	
}
