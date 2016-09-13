package com.car.dao;

import com.car.domain.UserSignlLogin;

public interface UserSignlLoginDao {

	void add(UserSignlLogin info);

	UserSignlLogin query(UserSignlLogin info);

	void update(UserSignlLogin info);

}
