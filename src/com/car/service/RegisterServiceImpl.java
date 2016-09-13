package com.car.service;

import java.util.UUID;

import com.car.dao.RegisterDao;
import com.car.domain.Register;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.util.SendPassCodeUtils;
import com.taobao.api.ApiException;

public class RegisterServiceImpl implements RegisterService {

	private RegisterDao dao = BasicFactory.getFactory().getInstance(
			RegisterDao.class);

	public void addRegister(Register register) throws MsgException {
		
		Register re = dao.findRegisterByPhone(register);

		if (re == null) {// 1.如果在数据库中根据phone查找为空，则进行插入新纪录，state设为0
			try {
				register.setState(0);
				String passcode = SendPassCodeUtils.sendPassCode(register
						.getPhone());
				register.setRegister_id(UUID.randomUUID().toString());
				register.setPasscode(passcode);
				dao.addRegister(register);
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.如果不为空，则检查state的值，且state为1则提示该用户已经注册
		} else if (re != null && (re.getState() == 1)) {			
			//throw new MsgException("该号码已被注册");
			throw new MsgException("1002");
			// 3.只需要更新state的值
		} else if (re != null && (re.getState() == 0)) {
			try {
				String passcode = null;
				long now = System.currentTimeMillis();
				if (re.getUpdatetime() == null) {//为空向注册表中添加记录
					passcode = SendPassCodeUtils.sendPassCode(register
							.getPhone());
					register.setPasscode(passcode);
					dao.updatePassCode(register);
				} else if ((now - re.getUpdatetime().getTime()) > 1000 * 60) {
					passcode = SendPassCodeUtils.sendPassCode(register
							.getPhone());
					register.setPasscode(passcode);
					dao.updatePassCode(register);

				} else {//再次获取但距离上次获取时间太近
					//throw new MsgException("获取验证码过于频繁!");
					throw new MsgException("1009");
				}
			} catch (ApiException e) {

				e.printStackTrace();
			}

		}

	}

	public void findRegisterByPhone(Register register) throws MsgException {
		// 1.先确认state的值，为1提示不能注册
		long now  = System.currentTimeMillis();
		Register re = dao.findRegisterByPhone(register);
		if (re == null) {
			//throw new MsgException("请先获取验证码!");
			throw new MsgException("1010");
		} else {
			if (re.getState() == 1) {
				//throw new MsgException("该号码已被注册过！！");
				throw new MsgException("1002");
			} else if (re.getState() == 0) {
				// 2.如果state为0，则去检验passcode的值与数据库中是否一致，一致则注册，state
				// 改为1,不一致则提示验证码不正确
				if ((re.getPasscode().equals(register.getPasscode()))&&(now - re.getUpdatetime().getTime())<1000*60*15) {
					//dao.updateState(register);
					//注册成功但不能立即修改state，到真的在user表中添加数据市再修改state 
					//throw new MsgException("验证成功,去设置您的基本信息吧!");
					throw new MsgException("1011");
				} else if((re.getPasscode().equals(register.getPasscode()))&&(now - re.getUpdatetime().getTime())>1000*60*15){
					//throw new MsgException("验证码超时!");
					throw new MsgException("1012");
				}else{
					//throw new MsgException("验证码错误!");
					throw new MsgException("1013");
				}
			}
		}

	}

}
