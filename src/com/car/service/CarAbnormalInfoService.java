package com.car.service;

import java.util.List;

import com.car.domain.CarAbnormalInfo;

public interface CarAbnormalInfoService {
	/**
	 * �����ݿ�����ӳ����쳣��Ϣ������쳣�����Ѵ��ڸó������쳣��Ϣ
	 * ��˵�������쳣��Ϣ�Ѿ���ά�����쳣���У��ҿͻ��˻�û���ü����մ��쳣��Ϣ����ʱ
	 * ����Ҫ����µ��쳣��Ϣ��¼��ֻ��Ҫ�����µ��쳣��Ϣ����ԭ������Ϣ����
	 * 
	 * @param info  JavaBean��װ���쳣��Ϣ 
	 */
	void addAbnormalInfo(CarAbnormalInfo info);
	/**
	 * �ȸ����ֻ�����ȥcarbaseinfo���в�ѯ���ֻ��������󶨵ĳ��ƺţ�
	 * �ٸ�����Щ���ƺ�ȥ�쳣���в�ѯ�Ƿ��иó������쳣��Ϣ
	 * �����������ӵ������У������еĳ��ƺű�����Ϻ��ٰѽ������
	 * @param phone �ͻ��˵�½ʱ���ֻ���
	 * @return �쳣��Ϣ�ļ���
	 */
	List<CarAbnormalInfo> queryByPhone(String phone);

}
