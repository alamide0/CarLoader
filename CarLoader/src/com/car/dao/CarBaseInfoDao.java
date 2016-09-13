package com.car.dao;

import java.util.List;

import com.car.domain.CarBaseInfo;

public interface CarBaseInfoDao {

	CarBaseInfo findCarInfoByCarNumberAndPhone(String carnumber,String phone);

	void addInfo(CarBaseInfo base);

	void updateInfo(CarBaseInfo base);

	List<CarBaseInfo> findInfoByPhone(String phone);

	CarBaseInfo findCarInfoByCarNumber(String carnumber);

}
