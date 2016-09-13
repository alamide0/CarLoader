package com.car.dao;

import java.util.List;

import com.car.domain.CarMaintainInfo;

public interface CarMaintainInfoDao {

	void addInfo(CarMaintainInfo maintain);

	int countRow(String carnumber);

	List<CarMaintainInfo> queryAll(String carnumber, String count);

	List<CarMaintainInfo> queryInfoByCount(String carnumber, int begin,
			int parseInt);

	List<CarMaintainInfo> queryAll(String carnumber, String phone, String count);

	List<CarMaintainInfo> queryInfoByCount(String carnumber, String phone,
			int i, int parseInt);


}
