package com.car.service;

import com.car.domain.ForgetPwd;
import com.car.domain.User;
import com.car.exception.MsgException;

public interface ForgetPwdService {
	/**
	 * 在数据库中添加忘记密码的用户
	 * @param forget	忘记密码用户对象
	 * @throws MsgException  向上层传递信息
	 */
	void addFor(ForgetPwd forget) throws MsgException;
	/**
	 * 更新忘记密码的用户，建立数据库的目的是保存忘记密码是的验证码
	 * @param forget 忘记密码的用户
	 * @param user 此处没用到
	 * @throws MsgException
	 */
	void updatePwd(ForgetPwd forget,User user) throws MsgException;
	/**
	 * 检验验证码是否正确
	 * @param forget 封装忘记密码用户的JAVABEAN
	 * @throws MsgException
	 */
	void checkPCode(ForgetPwd forget) throws MsgException;

}
