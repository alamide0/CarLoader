package com.car.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.car.domain.UserSignlLogin;
import com.car.util.DaoUtils;

public class UserSignlLoginDaoImpl implements UserSignlLoginDao {

	public void add(UserSignlLogin info) {
		try {
			String sql = "insert singlelogin values(null,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql,info.getPhone(),info.getOnlycode());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public UserSignlLogin query(UserSignlLogin info) {
		try {
			String sql = "select * from singlelogin where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<UserSignlLogin>(UserSignlLogin.class),info.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(UserSignlLogin info) {
		try {
			String sql = "update singlelogin set onlycode=? where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql,info.getOnlycode(),info.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
