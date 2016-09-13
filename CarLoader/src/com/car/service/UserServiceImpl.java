package com.car.service;

import com.car.dao.RegisterDao;
import com.car.dao.UserDao;
import com.car.domain.Register;
import com.car.domain.User;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;

public class UserServiceImpl implements UserService {
	RegisterDao daor = BasicFactory.getFactory().getInstance(RegisterDao.class);
	UserDao daou = BasicFactory.getFactory().getInstance(UserDao.class);

	public void addUser(User user) throws MsgException {
		Register register = daor.findIdByPhone(user);
		if (register != null) {
			String user_id = register.getRegister_id();
			user.setUser_id(user_id);
			// 1.根据ID查找用户看数据库中是否有该用户,为空加入用户
			if (daou.findUserById(user) == null) {
				{
					daou.addUser(user);
					daor.updateState(register);
					// throw new MsgException("注册成功!");
					throw new MsgException("1001");
				}
			} else {
				// throw new MsgException("该号码已被注册!");
				throw new MsgException("1002");
			}
		} else {
			// throw new MsgException("亲,先获取验证码!");
			throw new MsgException("1003");
		}
	}

	public void findUser(User user) throws MsgException {
		User u = daou.findUserByPhone(user);
		if (u == null || !u.getPassword().equals(user.getPassword())) {
			// throw new MsgException("用户名或密码错误");
			throw new MsgException("1004");
		} else if (u != null && u.getPassword().equals(user.getPassword())) {
			// throw new MsgException("登陆成功");
			throw new MsgException("1005");
		} else {
			// throw new MsgException("未知错误");
			throw new MsgException("1006");
		}

	}

	public void updatePwd(User user, String olderPwd) throws MsgException {
		User u = daou.findUserByPhone(user);

		if (u == null) {
			// throw new MsgException("用户名错误");
			throw new MsgException("1007");
		} else {
			daou.updateOnlyPwd(user);
			// throw new MsgException("修改成功");
			throw new MsgException("1008");
		}

	}

	public void updateName(User user) throws MsgException {
		User u = daou.findUserByPhone(user);
		if (u == null) {
			// throw new MsgException("用户名错误");
			throw new MsgException("1007");
		} else {
			daou.updateName(user);
			// throw new MsgException("修改成功");
			throw new MsgException("1008");
		}

	}

	public String queryNickName(String phone) {
		return daou.queryNickName(phone);
	}

	public String findUserFilter(User user) {
		User u = daou.findUserByPhone(user);
		if (u == null ) {
			// throw new MsgException("用户名或密码错误");
			return "1000";
		} 
		else if( !u.getPassword().equals(user.getPassword())){
			return "1004";
		}
		else if (u != null && u.getPassword().equals(user.getPassword())) {
		
			// throw new MsgException("登陆成功");
			// throw new MsgException("1005");
			return "1005";
		} else {
			// throw new MsgException("未知错误");
			// throw new MsgException("1006");
			return "1006";
		}
	}

}
