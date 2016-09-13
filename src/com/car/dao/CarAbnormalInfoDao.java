package com.car.dao;

import java.util.List;

import com.car.domain.CarAbnormalInfo;

public interface CarAbnormalInfoDao {

	CarAbnormalInfo findInfoByPhoneAndCarnumber(CarAbnormalInfo info);

	void updateAbnormalInfo(CarAbnormalInfo info);

	void addAbnormalInfo(CarAbnormalInfo info);

	CarAbnormalInfo queryByCarnumber(String carnumber);

	void deleteInfo(String carnumber);

}
