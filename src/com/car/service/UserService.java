package com.car.service;

import com.car.domain.User;
import com.car.exception.MsgException;

public interface UserService {
	/**
	 * ���û�������Ӽ�¼������������
	 * 1.��ȥע����в鿴�Ƿ��Ѿ���ȡ����֤�룬���û�л�ȡ������ʾ�Ȼ�ȡ��֤��
	 * 2.��ȥ�û������Ƿ���ڸü�¼�������������ʾ�ú�����ע��
	 * 
	 * @param user
	 * @throws MsgException
	 */
	void addUser(User user) throws MsgException;
	/**
	 * ��½ʱ�õķ�������ȥ�û�������֤�˺������룬��MsgException
	 * ���⴫���Ƿ���֤�ɹ�����Ϣ
	 * @param user
	 * @throws MsgException
	 */

	void findUser(User user) throws MsgException;

	/**
	 * �޸�������
	 * @param user
	 * @param olderPwd
	 * @throws MsgException
	 */
	void updatePwd(User user,String olderPwd ) throws MsgException;
	/**
	 * �޸�����
	 * @param user
	 * @throws MsgException
	 */
	void updateName(User user) throws MsgException;

	/**
	 * ��ѯ�ǳ�
	 * @param phone
	 * @return
	 */
	String queryNickName(String phone);
	/**
	 * �ڹ��������õĵ��÷���
	 * @param user
	 * @return
	 */
	String findUserFilter(User user);

}
