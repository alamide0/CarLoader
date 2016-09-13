package com.car.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.car.domain.CarAbnormalInfo;
import com.car.util.DaoUtils;

public class CarAbnormalInfoDaoImpl implements CarAbnormalInfoDao {

	public CarAbnormalInfo findInfoByPhoneAndCarnumber(CarAbnormalInfo info) {
		try {
			String sql = "select * from carabnormalinfo where carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<CarAbnormalInfo>(CarAbnormalInfo.class),info.getCarnumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateAbnormalInfo(CarAbnormalInfo info) {
		try {
			String sql = "update carabnormalinfo set state=? where carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, info.getState(),info.getCarnumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void addAbnormalInfo(CarAbnormalInfo info) {
		try {
			String sql = "insert into carabnormalinfo values(null,?,?,?,null)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, info.getPhone(),info.getCarnumber(),info.getState());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public CarAbnormalInfo queryByCarnumber(String carnumber) {
		try {
			String sql = "select * from carabnormalinfo where carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<CarAbnormalInfo>(CarAbnormalInfo.class),carnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteInfo(String carnumber) {
		try {
			String sql = "delete from carabnormalinfo where carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql, carnumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
