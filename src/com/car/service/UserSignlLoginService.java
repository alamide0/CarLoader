package com.car.service;

import com.car.domain.UserSignlLogin;

public interface UserSignlLoginService {
	/**所操作的表为标识是否单一登陆
	 * 在唯一登陆表中写入唯一码
	 * 
	 * @param info
	 */
	void add(UserSignlLogin info);
	/**
	 * 返回唯一登陆码，用于客户端检验是否唯一登陆
	 * @param phone
	 * @return
	 */
	String query(String phone);

}
