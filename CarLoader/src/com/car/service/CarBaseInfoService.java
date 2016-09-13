package com.car.service;

import java.util.List;

import com.car.domain.CarBaseInfo;

public interface CarBaseInfoService {
	/**
	 * 先根据base中封装的信息去carbaseinfo表中查找是否数据库中是否已经存储了
	 * 该车辆的信息，是否存在的标准是手机号和车牌号同时相等（因为本项目的设计理念是
	 * 一辆车可以被多个手机号所拥有，即一辆车可以被多个手机号维护）。如果已经存在则更新
	 *数据库的信息（防止造成数据重复及冗余），如果不存在则添加新的纪录
	 * @param base 封装车辆基本信息的JavaBean
	 */
	void addInfo(CarBaseInfo base);
	/**
	 * 根据手机号码查询该手机号码所绑定的车辆信息
	 * @param phone 手机号
	 * @return 车辆信息的集合
	 */
	List<CarBaseInfo> findInfoByPhone(String phone);
	/**
	 * 根据车牌号查询车辆的基本信息
	 * @param carnumber
	 * @return
	 */
	CarBaseInfo findInfoByCarNumber(String carnumber);

}
