package com.car.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.domain.CarOilOrderInfo;
import com.car.util.DaoUtils;

public class CarOilOrderInfoDaoImpl implements CarOilOrderInfoDao {

	public void storage(CarOilOrderInfo info) {
		try {
			String sql = "insert into oilorder values(null,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql,info.getCarnumber(),info.getName(),info.getOrdertime(),info.getStation(),info.getOil_type(),info.getMoney(),info.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CarOilOrderInfo> query(String phone) {
		try {
			String sql = "select * from oilorder where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarOilOrderInfo>(CarOilOrderInfo.class),phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
