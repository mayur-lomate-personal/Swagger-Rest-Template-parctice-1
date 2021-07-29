package com.pers.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PracticeLoginUser {

	@Id
	String userName;
	String pass;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
