package com.car.domain;

import java.io.Serializable;

public class CarBaseInfo implements Serializable{
	private int id;
	private String carnumber;
	private String phone;
	private String carenginnumber;
	private String carbrand;
	private String carsign;
	private String cartype;
	private String carbodylevel;
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCarenginnumber() {
		return carenginnumber;
	}
	public void setCarenginnumber(String carenginnumber) {
		this.carenginnumber = carenginnumber;
	}
	public String getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}
	public String getCarsign() {
		return carsign;
	}
	public void setCarsign(String carsign) {
		this.carsign = carsign;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarbodylevel() {
		return carbodylevel;
	}
	public void setCarbodylevel(String carbodylevel) {
		this.carbodylevel = carbodylevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
