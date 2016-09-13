package com.car.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.car.domain.ForgetPwd;
import com.car.exception.MsgException;
import com.car.util.DaoUtils;

public class ForgetPwdDaoImpl implements ForgetPwdDao{

	public void addFor(ForgetPwd forget) {
		try {
			String sql = "insert into forgetpwd values(null,?,?,null)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, forget.getPhone(),forget.getPasscode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ForgetPwd findFor(ForgetPwd forget) {
		try {
			String sql = "select * from forgetpwd where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<ForgetPwd>(ForgetPwd.class),forget.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updatePCode(ForgetPwd forget) {
		try {
			String sql = "update forgetpwd set passcode=? where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, forget.getPasscode(),forget.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void deleteFByPhone(ForgetPwd forget) {	
		try {
			String sql = "delete from forgetpwd where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, forget.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
