package com.car.service;

import com.car.domain.Register;
import com.car.exception.MsgException;

public interface RegisterService {
	/**
	 * 在register表中添加纪录
	 * @param register
	 * @throws MsgException
	 */
	void addRegister(Register register) throws MsgException;
	/**
	 * 查找register
	 * @param register
	 * @throws MsgException
	 */
	void findRegisterByPhone(Register register) throws MsgException;

}
