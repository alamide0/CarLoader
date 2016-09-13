package com.car.dao;

import com.car.domain.Register;
import com.car.domain.User;

public interface RegisterDao {

	Register findRegisterByPhone(Register register);

	void addRegister(Register register);

	void updatePassCode(Register register);

	void updateState(Register register);

	Register findIdByPhone(User user);

}
