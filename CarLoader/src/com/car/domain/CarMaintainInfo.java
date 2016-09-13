package com.car.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class CarMaintainInfo implements Serializable{
	private int id;
	private String carnumber;
	private String carmileage;
	private String caroil;
	private String carenginstate;
	private String cartranstate;
	private String carlightstate;
	private Timestamp updatetime;
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCarmileage() {
		return carmileage;
	}
	public void setCarmileage(String carmileage) {
		this.carmileage = carmileage;
	}
	public String getCaroil() {
		return caroil;
	}
	public void setCaroil(String caroil) {
		this.caroil = caroil;
	}
	public String getCarenginstate() {
		return carenginstate;
	}
	public void setCarenginstate(String carenginstate) {
		this.carenginstate = carenginstate;
	}
	public String getCartranstate() {
		return cartranstate;
	}
	public void setCartranstate(String cartranstate) {
		this.cartranstate = cartranstate;
	}
	public String getCarlightstate() {
		return carlightstate;
	}
	public void setCarlightstate(String carlightstate) {
		this.carlightstate = carlightstate;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	
}
