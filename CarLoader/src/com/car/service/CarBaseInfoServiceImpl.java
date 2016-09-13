package com.car.service;

import java.util.List;

import com.car.dao.CarBaseInfoDao;
import com.car.domain.CarBaseInfo;
import com.car.factory.BasicFactory;

public class CarBaseInfoServiceImpl implements CarBaseInfoService {
	CarBaseInfoDao dao = BasicFactory.getFactory().getInstance(CarBaseInfoDao.class);
	public void addInfo(CarBaseInfo base) {
		CarBaseInfo info = dao.findCarInfoByCarNumberAndPhone(base.getCarnumber(),base.getPhone());
		if(info==null){
			dao.addInfo(base);
		}else if((info.getPhone().equals(base.getPhone()))&&(info.getCarnumber().equals(base.getCarnumber()))){
			//System.out.println("zhoixoachosdhal");
			dao.updateInfo(base);
		}else{
			dao.addInfo(base);
		}
	}
	public List<CarBaseInfo> findInfoByPhone(String phone) {
		return dao.findInfoByPhone(phone);
		//return null;
	}
	public CarBaseInfo findInfoByCarNumber(String carnumber) {
		
		return dao.findCarInfoByCarNumber(carnumber);
	}

}
