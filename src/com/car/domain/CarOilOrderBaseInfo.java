package com.car.domain;

import java.io.Serializable;

public class CarOilOrderBaseInfo implements Serializable{
	private int id;
	private String phone;
	private String carnumber;

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

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

}
