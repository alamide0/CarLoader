package com.car.service;

import java.util.List;

import com.car.domain.CarMaintainInfo;

public interface CarMaintainInfoService {
	/**
	 * 0000 0001 ��ʾ����������20%
	 * 0000 0010 ��ʾ�����ÿ����15000KM�ı���
	 * 0000 0100 ��ʾ�����������쳣
	 * 0000 1000 ��ʾ�����������쳣
	 * 0001 0000 ��ʾ���Ƴ����쳣
	 * 
	 * 
	 * BUG�Ƿ������ݿ�����һ��state�����û�ά����֮������Ϊ1����ֹ�ظ����ѣ��ѽ����
	 * �����ݿ��м�¼������ά����Ϣ��������ά������Ϣ�ó������������״̬
	 * ����Ŀ��������ð�λ�뽫����״̬��һ�����ֱ�ʾ������Ľ�Լ�˴洢�ռ�����ݴ���
	 * ��ռ�õ�����
	 * 
	 * 
	 * @param maintain
	 * @return �����������״̬
	 */
	int addInfo(CarMaintainInfo maintain);

	/**
	 * ���ݳ��ƺŲ�ѯ�ó���������ά����Ϣ�����1---count����
	 * @param carnumber
	 * @param count ����Ķ�����
	 * @return ����ά����Ϣ�ļ���
	 */
	List<CarMaintainInfo> queryInfoByCount(String carnumber, String count);
 
	/**
	 * ��ѯ���ֻ�������ά���ĳ�����Ϣ�����ڱ���Ŀ���õ�һ�������Ա�����ֻ���ά����ԭ��
	 * �����ṩ�÷��������û�ѡ��
	 * @param carnumber
	 * @param phone
	 * @param count
	 * @return ����ά����Ϣ�ļ���
	 */
	List<CarMaintainInfo> queryInfoByPhoneAndCount(String carnumber,
			String phone, String count);

	

}
