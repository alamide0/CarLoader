package com.car.service;

import com.car.domain.ForgetPwd;
import com.car.domain.User;
import com.car.exception.MsgException;

public interface ForgetPwdService {
	/**
	 * �����ݿ����������������û�
	 * @param forget	���������û�����
	 * @throws MsgException  ���ϲ㴫����Ϣ
	 */
	void addFor(ForgetPwd forget) throws MsgException;
	/**
	 * ��������������û����������ݿ��Ŀ���Ǳ������������ǵ���֤��
	 * @param forget ����������û�
	 * @param user �˴�û�õ�
	 * @throws MsgException
	 */
	void updatePwd(ForgetPwd forget,User user) throws MsgException;
	/**
	 * ������֤���Ƿ���ȷ
	 * @param forget ��װ���������û���JAVABEAN
	 * @throws MsgException
	 */
	void checkPCode(ForgetPwd forget) throws MsgException;

}
