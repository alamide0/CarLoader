package com.car.dao;

import java.util.List;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.domain.CarOilOrderInfo;

public interface CarOilOrderInfoDao {

	void storage(CarOilOrderInfo info);

	List<CarOilOrderInfo> query(String phone);

}
