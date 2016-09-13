package com.car.service;

import java.util.List;

import com.car.domain.CarBaseInfo;

public interface CarBaseInfoService {
	/**
	 * �ȸ���base�з�װ����Ϣȥcarbaseinfo���в����Ƿ����ݿ����Ƿ��Ѿ��洢��
	 * �ó�������Ϣ���Ƿ���ڵı�׼���ֻ��źͳ��ƺ�ͬʱ��ȣ���Ϊ����Ŀ�����������
	 * һ�������Ա�����ֻ�����ӵ�У���һ�������Ա�����ֻ���ά����������Ѿ����������
	 *���ݿ����Ϣ����ֹ��������ظ������ࣩ�����������������µļ�¼
	 * @param base ��װ����������Ϣ��JavaBean
	 */
	void addInfo(CarBaseInfo base);
	/**
	 * �����ֻ������ѯ���ֻ��������󶨵ĳ�����Ϣ
	 * @param phone �ֻ���
	 * @return ������Ϣ�ļ���
	 */
	List<CarBaseInfo> findInfoByPhone(String phone);
	/**
	 * ���ݳ��ƺŲ�ѯ�����Ļ�����Ϣ
	 * @param carnumber
	 * @return
	 */
	CarBaseInfo findInfoByCarNumber(String carnumber);

}
