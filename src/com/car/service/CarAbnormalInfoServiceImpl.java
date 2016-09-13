package com.car.service;

import java.util.ArrayList;
import java.util.List;

import com.car.dao.CarAbnormalInfoDao;
import com.car.dao.CarBaseInfoDao;
import com.car.domain.CarAbnormalInfo;
import com.car.domain.CarBaseInfo;
import com.car.factory.BasicFactory;

public class CarAbnormalInfoServiceImpl implements CarAbnormalInfoService {
	CarAbnormalInfoDao dao = BasicFactory.getFactory().getInstance(CarAbnormalInfoDao.class);
	
	public void addAbnormalInfo(CarAbnormalInfo info) {
		CarAbnormalInfo q = dao.findInfoByPhoneAndCarnumber(info);
		if(q!=null){
			dao.updateAbnormalInfo(info);
		}else{
			dao.addAbnormalInfo(info);
		}
	}
	public List<CarAbnormalInfo> queryByPhone(String phone) {
		CarBaseInfoDao cd = BasicFactory.getFactory().getInstance(CarBaseInfoDao.class);
		List<CarBaseInfo> list = cd.findInfoByPhone(phone);
		List<CarAbnormalInfo> l = new ArrayList<CarAbnormalInfo>();
		//System.out.println(list.size()+"size");
		long now = System.currentTimeMillis();
		for(int i=0; i<list.size();i++){
			CarAbnormalInfo info  = dao.queryByCarnumber(list.get(i).getCarnumber());
			if(info!=null)
				if((now-info.getUpdatetime().getTime())>1000*120)
					dao.deleteInfo(list.get(i).getCarnumber());
				else
					l.add(info);
		}
		return l;
	}

}
