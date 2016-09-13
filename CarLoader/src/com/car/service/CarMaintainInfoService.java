package com.car.service;

import java.util.List;

import com.car.domain.CarMaintainInfo;

public interface CarMaintainInfoService {
	/**
	 * 0000 0001 表示汽油量少于20%
	 * 0000 0010 表示里程数每超过15000KM的倍数
	 * 0000 0100 表示发动机出现异常
	 * 0000 1000 表示变速器出现异常
	 * 0001 0000 表示车灯出现异常
	 * 
	 * 
	 * BUG是否在数据库设置一个state，当用户维护过之后设置为1，防止重复提醒（已解决）
	 * 向数据库中记录车辆的维护信息，并根据维护的信息得出各汽车组件的状态
	 * 本项目巧妙地利用按位与将所有状态用一个数字表示，极大的节约了存储空间和数据传输
	 * 所占用的流量
	 * 
	 * 
	 * @param maintain
	 * @return 汽车各组件的状态
	 */
	int addInfo(CarMaintainInfo maintain);

	/**
	 * 根据车牌号查询该车辆的所有维护信息（最近1---count条）
	 * @param carnumber
	 * @param count 最近的多少条
	 * @return 车辆维护信息的集合
	 */
	List<CarMaintainInfo> queryInfoByCount(String carnumber, String count);
 
	/**
	 * 查询本手机号码所维护的车辆信息，由于本项目采用的一辆车可以被多个手机号维护的原则
	 * 所以提供该方法来让用户选择
	 * @param carnumber
	 * @param phone
	 * @param count
	 * @return 车辆维护信息的集合
	 */
	List<CarMaintainInfo> queryInfoByPhoneAndCount(String carnumber,
			String phone, String count);

	

}
