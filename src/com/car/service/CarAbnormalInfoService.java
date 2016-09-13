package com.car.service;

import java.util.List;

import com.car.domain.CarAbnormalInfo;

public interface CarAbnormalInfoService {
	/**
	 * 向数据库中添加车辆异常信息，如果异常表中已存在该车辆的异常信息
	 * 则说明该条异常信息已经被维护到异常表中，且客户端还没来得及接收此异常信息，此时
	 * 不需要添加新的异常信息记录，只需要把最新的异常信息覆盖原来的信息即可
	 * 
	 * @param info  JavaBean封装的异常信息 
	 */
	void addAbnormalInfo(CarAbnormalInfo info);
	/**
	 * 先根据手机号码去carbaseinfo表中查询本手机号码所绑定的车牌号，
	 * 再根据这些车牌号去异常表中查询是否有该车辆的异常信息
	 * 如果有则先添加到集合中，等所有的车牌号遍历完毕后再把结果返回
	 * @param phone 客户端登陆时的手机号
	 * @return 异常信息的集合
	 */
	List<CarAbnormalInfo> queryByPhone(String phone);

}
