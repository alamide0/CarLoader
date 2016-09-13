package com.car.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.util.DaoUtils;

public class CarOilOrderBaseInfoDaoImpl implements CarOilOrderBaseInfoDao {

	public CarOilOrderBaseInfo query(CarOilOrderBaseInfo info) {
		try {
			String sql = "select * from oilcarinfo where phone=? and carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<CarOilOrderBaseInfo>(
					CarOilOrderBaseInfo.class), info.getPhone(), info
					.getCarnumber());
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
		

	}

	public void add(CarOilOrderBaseInfo info) {
		try {
			String sql = "insert into oilcarinfo values(null,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, info.getPhone(), info.getCarnumber());
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public List<CarOilOrderBaseInfo> queryCarNumberByPhone(String phone) {
		try {
			String sql = "select * from oilcarinfo where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarOilOrderBaseInfo>(CarOilOrderBaseInfo.class),phone);
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}



}
