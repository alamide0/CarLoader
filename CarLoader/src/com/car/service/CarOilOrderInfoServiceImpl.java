package com.car.service;

import java.util.List;

import com.car.dao.CarOilOrderBaseInfoDao;
import com.car.dao.CarOilOrderInfoDao;
import com.car.domain.CarOilOrderBaseInfo;
import com.car.domain.CarOilOrderInfo;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;


public class CarOilOrderInfoServiceImpl implements CarOilOrderInfoService {

	CarOilOrderInfoDao dao = BasicFactory.getFactory().getInstance(CarOilOrderInfoDao.class);
	
	public void storage(CarOilOrderInfo info) throws MsgException {
		dao.storage(info);
		throw new MsgException("3003");
	}

	public List<CarOilOrderInfo> query(String phone) {
		return dao.query(phone);
		
	}

}
