package com.car.service;

import java.util.List;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.exception.MsgException;

public interface CarOilOrderBaseInfoService {

	/**
	 * CarOilOrderBaseInfo��ָ�����Ļ�����Ϣ���൱�ڷ�Ʊ��̧ͷ
	 * �򶩵�������Ϣ������ӻ�����Ϣ������Ѵ��ڸü�¼����ʾ�û�
	 * �Ѵ��ڵĸ������ֻ����복�ƺ�ͬʱ���
	 * @param info
	 * @throws MsgException ���쳣���ϴ�����Ϣ
	 */
	void add(CarOilOrderBaseInfo info) throws MsgException;

	/**
	 * �����ֻ������ѯ���ݿ��и��ֻ�������ӵĳ��ƺţ����ص���һ�����϶��󣬱����������
	 * ȡ�����еĳ��ƺ�
	 * @param phone
	 * @return ���ƺŵļ���
	 */
	List<String> queryCarNumberByPhone(String phone);

}
