package com.car.service;

import com.car.domain.User;
import com.car.exception.MsgException;

public interface UserService {
	/**
	 * 向用户表中添加纪录操作步骤如下
	 * 1.先去注册表中查看是否已经获取过验证码，如果没有获取过则提示先获取验证码
	 * 2.再去用户表中是否存在该记录，如果存在则提示该号码已注册
	 * 
	 * @param user
	 * @throws MsgException
	 */
	void addUser(User user) throws MsgException;
	/**
	 * 登陆时用的方法，即去用户表中验证账号与密码，用MsgException
	 * 向外传递是否验证成功的信息
	 * @param user
	 * @throws MsgException
	 */

	void findUser(User user) throws MsgException;

	/**
	 * 修改密码用
	 * @param user
	 * @param olderPwd
	 * @throws MsgException
	 */
	void updatePwd(User user,String olderPwd ) throws MsgException;
	/**
	 * 修改密码
	 * @param user
	 * @throws MsgException
	 */
	void updateName(User user) throws MsgException;

	/**
	 * 查询昵称
	 * @param phone
	 * @return
	 */
	String queryNickName(String phone);
	/**
	 * 在过滤器中用的调用方法
	 * @param user
	 * @return
	 */
	String findUserFilter(User user);

}
