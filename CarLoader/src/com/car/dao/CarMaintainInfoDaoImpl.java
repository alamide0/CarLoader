package com.car.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.car.domain.CarMaintainInfo;
import com.car.util.DaoUtils;

public class CarMaintainInfoDaoImpl implements CarMaintainInfoDao{

	public void addInfo(CarMaintainInfo maintain) {
		try {
			String sql = "insert into carmaintaininfo values (null,?,?,?,?,?,?,null,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, 
					maintain.getCarnumber(),
					maintain.getCarmileage(),
					maintain.getCaroil(),
					maintain.getCarenginstate(),
					maintain.getCartranstate(),
					maintain.getCarlightstate(),
					maintain.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int countRow(String carnumber) {
		
		try {
			String sql = "select count(*) from carmaintaininfo where carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return ((Long)runner.query(sql, new ScalarHandler(),carnumber)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<CarMaintainInfo> queryAll(String carnumber, String count) {
		try {
			String sql = "select * from carmaintaininfo where carnumber=? order by updatetime desc";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarMaintainInfo>(CarMaintainInfo.class),carnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public List<CarMaintainInfo> queryInfoByCount(String carnumber, int begin,
			int parseInt) {
		try {
			String sql = "select * from carmaintaininfo where carnumber=? order by updatetime desc limit ?,? ";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarMaintainInfo>(CarMaintainInfo.class),carnumber,begin,parseInt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CarMaintainInfo> queryAll(String carnumber, String phone,
			String count) {
		try {
			String sql = "select * from carmaintaininfo where carnumber=? and phone=? order by updatetime desc";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarMaintainInfo>(CarMaintainInfo.class),carnumber,phone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CarMaintainInfo> queryInfoByCount(String carnumber,
			String phone, int begin, int parseInt) {
		try {
			String sql = "select * from carmaintaininfo where carnumber=? and phone=? order by updatetime desc limit ?,? ";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarMaintainInfo>(CarMaintainInfo.class),carnumber,phone,begin,parseInt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
