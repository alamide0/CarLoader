package com.car.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.car.domain.Register;
import com.car.domain.User;
import com.car.util.DaoUtils;

public class RegisterDaoImpl implements RegisterDao {

	public Register findRegisterByPhone(Register register) {
		String sql = "select * from register where phone = ?";
		QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
		try {
			return runner.query(sql, new BeanHandler<Register>(Register.class),register.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void addRegister(Register register) {
		String sql = "insert into register values(?,?,?,null,?)";
		QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
		try {
			 runner.update(sql,
					register.getRegister_id(),
					register.getPhone(),
					register.getState(),
					register.getPasscode());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updatePassCode(Register register) {
		String sql = "update register set passcode=? where phone=?";
		QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
		try {
			 runner.update(sql, register.getPasscode(),register.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateState(Register register) {
		String sql = "update register set state=1 where phone=?";
		QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
		try {
			 runner.update(sql, register.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public Register findIdByPhone(User user) {
		String sql = "select * from register where phone=?";
		QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
		try {
			return runner.query(sql, new BeanHandler<Register>(Register.class),user.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
