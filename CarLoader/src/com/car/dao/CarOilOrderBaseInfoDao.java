package com.car.dao;

import java.util.List;

import com.car.domain.CarOilOrderBaseInfo;

public interface CarOilOrderBaseInfoDao {

	CarOilOrderBaseInfo query(CarOilOrderBaseInfo info);

	void add(CarOilOrderBaseInfo info);

	List<CarOilOrderBaseInfo> queryCarNumberByPhone(String phone);

	

}
