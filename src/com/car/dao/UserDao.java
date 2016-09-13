package com.car.dao;

import com.car.domain.User;

public interface UserDao {

	User findUserById(User user);

	void addUser(User user);

	User findUserByPhone(User user);

	void updatePwd(User user);

	void updateOnlyPwd(User user);

	void updateName(User user);

	String queryNickName(String phone);

}
