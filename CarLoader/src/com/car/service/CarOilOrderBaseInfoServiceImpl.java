package com.car.service;

import java.util.ArrayList;
import java.util.List;

import com.car.dao.CarOilOrderBaseInfoDao;
import com.car.domain.CarOilOrderBaseInfo;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;

public class CarOilOrderBaseInfoServiceImpl implements
		CarOilOrderBaseInfoService {
	CarOilOrderBaseInfoDao dao = BasicFactory.getFactory().getInstance(
			CarOilOrderBaseInfoDao.class);

	public void add(CarOilOrderBaseInfo info) throws MsgException {
		CarOilOrderBaseInfo temp = dao.query(info);
		if (temp != null) {
			throw new MsgException("3002");
		} else {
			dao.add(info);
			throw new MsgException("3001");
		}
	}

	public List<String> queryCarNumberByPhone(String phone) {
		List<CarOilOrderBaseInfo> list = dao.queryCarNumberByPhone(phone);
		List<String> strs = new ArrayList<String>();
		if (list != null) {
			for (CarOilOrderBaseInfo info : list) {
				strs.add(info.getCarnumber());
			}
		}
		return strs;
	}

}
