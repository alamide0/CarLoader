package com.car.service;

import java.util.List;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.domain.CarOilOrderInfo;
import com.car.exception.MsgException;

public interface CarOilOrderInfoService {
	/**
	 * �洢������Ϣ 
	 * @param info ��װ������Ϣ��JavaBean
	 * @throws MsgException �������ϲ㴫�ݴ���Ľ��
	 */

	void storage(CarOilOrderInfo info) throws MsgException;

	/**
	 * ��ѯ������Ϣ
	 * @param phone
	 * @return ���ض�����Ϣ�ļ���
	 */
	List<CarOilOrderInfo> query(String phone);

}
