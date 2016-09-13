package com.car.service;

import java.util.List;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.domain.CarOilOrderInfo;
import com.car.exception.MsgException;

public interface CarOilOrderInfoService {
	/**
	 * 存储订单信息 
	 * @param info 封装订单信息的JavaBean
	 * @throws MsgException 用于向上层传递处理的结果
	 */

	void storage(CarOilOrderInfo info) throws MsgException;

	/**
	 * 查询订单信息
	 * @param phone
	 * @return 返回订单信息的集合
	 */
	List<CarOilOrderInfo> query(String phone);

}
