package com.car.service;

import com.car.dao.UserSignlLoginDao;
import com.car.domain.UserSignlLogin;
import com.car.factory.BasicFactory;

public class UserSignlLoginServiceImpl implements UserSignlLoginService {

	UserSignlLoginDao dao = BasicFactory.getFactory().getInstance(UserSignlLoginDao.class);
	public void add(UserSignlLogin info) {
		UserSignlLogin user = dao.query(info);
		if(user==null){
			dao.add(info);
		}else{
			dao.update(info);
		}
	}
	public String query(String phone) {
		UserSignlLogin info = new UserSignlLogin();
		info.setPhone(phone);
		UserSignlLogin user = dao.query(info);
		return user==null?"":user.getOnlycode();
	}
	
}
