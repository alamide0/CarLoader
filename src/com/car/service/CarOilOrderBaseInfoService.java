package com.car.service;

import java.util.List;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.exception.MsgException;

public interface CarOilOrderBaseInfoService {

	/**
	 * CarOilOrderBaseInfo是指订单的基本信息，相当于发票的抬头
	 * 向订单基本信息表中添加基本信息，如果已存在该记录则提示用户
	 * 已存在的根据是手机号与车牌号同时相等
	 * @param info
	 * @throws MsgException 用异常向上传递信息
	 */
	void add(CarOilOrderBaseInfo info) throws MsgException;

	/**
	 * 根据手机号码查询数据库中该手机号所添加的车牌号，返回的是一个集合对象，遍历这个对象
	 * 取出其中的车牌号
	 * @param phone
	 * @return 车牌号的集合
	 */
	List<String> queryCarNumberByPhone(String phone);

}
