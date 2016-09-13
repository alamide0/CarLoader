package com.car.service;

import com.car.dao.ForgetPwdDao;
import com.car.dao.UserDao;
import com.car.domain.ForgetPwd;
import com.car.domain.User;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.util.SendPassCodeUtils;
import com.taobao.api.ApiException;

public class ForgetPwdServiceImpl implements ForgetPwdService {
	ForgetPwdDao dao = BasicFactory.getFactory()
			.getInstance(ForgetPwdDao.class);
	UserDao daou = BasicFactory.getFactory().getInstance(UserDao.class);
	public void addFor(ForgetPwd forget) throws MsgException {
		// 先发送验证码
		try {
			ForgetPwd fo = dao.findFor(forget);
			User user = new User();
			user.setPhone(forget.getPhone());
			User u = daou.findUserByPhone(user);
			if(u==null){//先检查是否为有效账户
				//throw new MsgException("该用户未注册");
				throw new MsgException("1014");
			}
			if (fo == null) {
				String str = SendPassCodeUtils.sendPassCode(forget.getPhone());
				forget.setPasscode(str);
				dao.addFor(forget);
			} else {
				long now = System.currentTimeMillis();
				if ((now - fo.getUpdatetime().getTime()) >1000 * 60 ) {
					String str = SendPassCodeUtils.sendPassCode(forget
							.getPhone());
					forget.setPasscode(str);
					dao.updatePCode(forget);
				}else{
					//throw new MsgException("验证码获取太频繁");
					throw new MsgException("1009");
				}
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	public void updatePwd(ForgetPwd forget,User user) throws MsgException {
		ForgetPwd fo = dao.findFor(forget);
		User u = daou.findUserByPhone(user);
		if(fo.getPasscode().equals(forget.getPasscode())){
			daou.updateOnlyPwd(user);
			dao.deleteFByPhone(forget);
			//throw new MsgException("密码重设成功");
			throw new MsgException("1015");
		}else{
			//throw new MsgException("验证码错误");
			throw new MsgException("1013");
		}
		
		
	}
	public void checkPCode(ForgetPwd forget) throws MsgException {
		ForgetPwd fo = dao.findFor(forget);
		if(fo.getPasscode().equals(forget.getPasscode())){
			//throw new MsgException("验证码正确");
			throw new MsgException("1016");
		}else{
			//throw new MsgException("验证码错误");
			throw new MsgException("1013");
		}
		
	}

}
