package com.car.dao;

import java.sql.SQLException;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.car.domain.User;
import com.car.util.DaoUtils;

public class UserDaoImpl implements UserDao {

	public User findUserById(User user) {	
		try {
			String sql = "select * from user where user_id=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<User>(User.class),user.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void addUser(User user) {
		try {
			String sql = "insert into user values (?,?,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql,user.getUser_id(),user.getPhone(),user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User findUserByPhone(User user) {
		try {
			String sql = "select * from user where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<User>(User.class),user.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updatePwd(User user) {		
		try {
			String sql = "update user set password=?,username=? where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			System.out.println(user.getPassword()+":"+user.getUsername()+":"+user.getPhone());
			runner.update(sql, user.getPassword(),user.getUsername(),user.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateOnlyPwd(User user) {
		try {
			String sql = "update user set password=? where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			//System.out.println(user.getPassword()+":"+user.getUsername()+":"+user.getPhone());
			runner.update(sql, user.getPassword(),user.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateName(User user) {
		try {
			String sql = "update user set username=? where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			//System.out.println(user.getPassword()+":"+user.getUsername()+":"+user.getPhone());
			runner.update(sql, user.getUsername(),user.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String queryNickName(String phone) {
		try {
			String sql = "select * from user where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			User user = runner.query(sql, new BeanHandler<User>(User.class), phone);
			if(user!=null){
				return user.getUsername();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
