package com.car.dao;

import com.car.domain.ForgetPwd;

public interface ForgetPwdDao {

	void addFor(ForgetPwd forget);

	ForgetPwd findFor(ForgetPwd forget);

	void updatePCode(ForgetPwd forget);

	void deleteFByPhone(ForgetPwd forget);

}
