package com.car.service;

import com.car.domain.UserSignlLogin;

public interface UserSignlLoginService {
	/**�������ı�Ϊ��ʶ�Ƿ�һ��½
	 * ��Ψһ��½����д��Ψһ��
	 * 
	 * @param info
	 */
	void add(UserSignlLogin info);
	/**
	 * ����Ψһ��½�룬���ڿͻ��˼����Ƿ�Ψһ��½
	 * @param phone
	 * @return
	 */
	String query(String phone);

}
