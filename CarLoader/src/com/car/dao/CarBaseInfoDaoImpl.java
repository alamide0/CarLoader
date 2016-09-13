package com.car.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.car.domain.CarBaseInfo;
import com.car.util.DaoUtils;

public class CarBaseInfoDaoImpl implements CarBaseInfoDao {

	public void addInfo(CarBaseInfo base) {
		try {
			String sql = "insert into carbaseinfo values(null,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql,
						base.getCarnumber(),
						base.getPhone(),
						base.getCarenginnumber(),
						base.getCarbrand(),
						base.getCarsign(),
						base.getCartype(),
						base.getCarbodylevel()
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateInfo(CarBaseInfo base) {
		try {
			String sql = "update carbaseinfo set phone=?,carenginnumber=?,carbrand=?,carsign=?,cartype=?,carbodylevel=? where carnumber=? and phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			runner.update(sql,
						base.getPhone(),
						base.getCarenginnumber(),
						base.getCarbrand(),
						base.getCarsign(),
						base.getCartype(),
						base.getCarbodylevel(),
						base.getCarnumber(),
						base.getPhone()
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<CarBaseInfo> findInfoByPhone(String phone) {
		try {
			String sql = "select * from carbaseinfo where phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanListHandler<CarBaseInfo>(CarBaseInfo.class),
					phone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CarBaseInfo findCarInfoByCarNumberAndPhone(String carnumber,String phone) {
		try {
			String sql = "select * from carbaseinfo where carnumber=? and phone=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<CarBaseInfo>(CarBaseInfo.class),
					carnumber,phone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CarBaseInfo findCarInfoByCarNumber(String carnumber) {
		try {
			String sql = "select * from carbaseinfo where carnumber=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSourse());
			return runner.query(sql, new BeanHandler<CarBaseInfo>(CarBaseInfo.class),
					carnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
