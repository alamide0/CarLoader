package com.car.service;

import com.car.domain.Register;
import com.car.exception.MsgException;

public interface RegisterService {
	/**
	 * ��register������Ӽ�¼
	 * @param register
	 * @throws MsgException
	 */
	void addRegister(Register register) throws MsgException;
	/**
	 * ����register
	 * @param register
	 * @throws MsgException
	 */
	void findRegisterByPhone(Register register) throws MsgException;

}
