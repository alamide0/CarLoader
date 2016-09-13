package com.car.service;

import java.util.List;

import com.car.dao.CarMaintainInfoDao;
import com.car.domain.CarAbnormalInfo;
import com.car.domain.CarMaintainInfo;
import com.car.factory.BasicFactory;

public class CarMaintainInfoServiceImpl implements CarMaintainInfoService {
	CarMaintainInfoDao dao = BasicFactory.getFactory().getInstance(
			CarMaintainInfoDao.class);
	CarAbnormalInfoService service = BasicFactory.getFactory().getInstance(
			CarAbnormalInfoService.class);

	public int addInfo(CarMaintainInfo maintain) {
//		int tt = 0;
//		List<CarMaintainInfo> list = dao.queryInfoByCount(maintain
//				.getCarnumber(), 0, 1);
//		if (list != null && list.size() > 0) {
//			CarMaintainInfo c = list.get(0);
//			if (c != null) {
//				double oill = Double.parseDouble(c.getCaroil());
//				if (oill < 0.2) {
//					tt = tt | 1;
//				}
//				double kmm = Double.parseDouble(c.getCarmileage());
//				if ((int) kmm / 15000 > 0) {
//					tt = tt | 2;
//				}
//
//				if ("1".equals(c.getCarenginstate())) {
//					tt = tt | 4;
//				}
//				if ("1".equals(c.getCartranstate())) {
//					tt = tt | 8;
//				}
//
//				if ("1".equals(c.getCarlightstate())) {
//					tt = tt | 16;
//				}
//			}
//		}

		dao.addInfo(maintain);
		int t = 0;

		double oil = Double.parseDouble(maintain.getCaroil());
		if (oil < 0.2) {
			t = t | 1;
		}
		double km = Double.parseDouble(maintain.getCarmileage());
		if ((int) km / 15000 > 0) {
			t = t | 2;
		}

		if ("0".equals(maintain.getCarenginstate())) {
			t = t | 4;
		}
		if ("0".equals(maintain.getCartranstate())) {
			t = t | 8;
		}

		if ("0".equals(maintain.getCarlightstate())) {
			t = t | 16;
		}

		// 防止重复多次发送维护信息，所以在维护信息与上一次维护信息相同时不再向异常表中添加异常信息
//		if (t > 0 && tt != t) {
//			CarAbnormalInfo info = new CarAbnormalInfo();
//			info.setPhone(maintain.getPhone());
//			info.setCarnumber(maintain.getCarnumber());
//			info.setState(t);
//			service.addAbnormalInfo(info);
//		}
		if (t > 0) {
			CarAbnormalInfo info = new CarAbnormalInfo();
			info.setPhone(maintain.getPhone());
			info.setCarnumber(maintain.getCarnumber());
			info.setState(t);
			service.addAbnormalInfo(info);
		}
		return t;

	}

	public List<CarMaintainInfo> queryInfoByCount(String carnumber, String count) {
		int row = dao.countRow(carnumber);
		if (row <= Integer.parseInt(count)) {
			return dao.queryAll(carnumber, count);
		} else {
			int begin = row - Integer.parseInt(count);
			// System.out.println(begin);
			return dao.queryInfoByCount(carnumber, 0, Integer.parseInt(count));
		}
	}

	public List<CarMaintainInfo> queryInfoByPhoneAndCount(String carnumber,
			String phone, String count) {
		int row = dao.countRow(carnumber);
		if (row <= Integer.parseInt(count)) {
			return dao.queryAll(carnumber, phone, count);
		} else {
			int begin = row - Integer.parseInt(count);
			//System.out.println(begin);
			return dao.queryInfoByCount(carnumber, phone, 0, Integer
					.parseInt(count));
		}
	}

}
