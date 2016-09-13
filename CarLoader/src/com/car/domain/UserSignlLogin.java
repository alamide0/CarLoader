package com.car.domain;

import java.io.Serializable;

public class UserSignlLogin implements Serializable{
	private int id;
	private String phone;
	private String onlycode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOnlycode() {
		return onlycode;
	}
	public void setOnlycode(String onlycode) {
		this.onlycode = onlycode;
	}
	
}
