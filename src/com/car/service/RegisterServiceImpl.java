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

		if (re == null) {// 1.��������ݿ��и���phone����Ϊ�գ�����в����¼�¼��state��Ϊ0
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
			// 2.�����Ϊ�գ�����state��ֵ����stateΪ1����ʾ���û��Ѿ�ע��
		} else if (re != null && (re.getState() == 1)) {			
			//throw new MsgException("�ú����ѱ�ע��");
			throw new MsgException("1002");
			// 3.ֻ��Ҫ����state��ֵ
		} else if (re != null && (re.getState() == 0)) {
			try {
				String passcode = null;
				long now = System.currentTimeMillis();
				if (re.getUpdatetime() == null) {//Ϊ����ע�������Ӽ�¼
					passcode = SendPassCodeUtils.sendPassCode(register
							.getPhone());
					register.setPasscode(passcode);
					dao.updatePassCode(register);
				} else if ((now - re.getUpdatetime().getTime()) > 1000 * 60) {
					passcode = SendPassCodeUtils.sendPassCode(register
							.getPhone());
					register.setPasscode(passcode);
					dao.updatePassCode(register);

				} else {//�ٴλ�ȡ�������ϴλ�ȡʱ��̫��
					//throw new MsgException("��ȡ��֤�����Ƶ��!");
					throw new MsgException("1009");
				}
			} catch (ApiException e) {

				e.printStackTrace();
			}

		}

	}

	public void findRegisterByPhone(Register register) throws MsgException {
		// 1.��ȷ��state��ֵ��Ϊ1��ʾ����ע��
		long now  = System.currentTimeMillis();
		Register re = dao.findRegisterByPhone(register);
		if (re == null) {
			//throw new MsgException("���Ȼ�ȡ��֤��!");
			throw new MsgException("1010");
		} else {
			if (re.getState() == 1) {
				//throw new MsgException("�ú����ѱ�ע�������");
				throw new MsgException("1002");
			} else if (re.getState() == 0) {
				// 2.���stateΪ0����ȥ����passcode��ֵ�����ݿ����Ƿ�һ�£�һ����ע�ᣬstate
				// ��Ϊ1,��һ������ʾ��֤�벻��ȷ
				if ((re.getPasscode().equals(register.getPasscode()))&&(now - re.getUpdatetime().getTime())<1000*60*15) {
					//dao.updateState(register);
					//ע��ɹ������������޸�state���������user����������������޸�state 
					//throw new MsgException("��֤�ɹ�,ȥ�������Ļ�����Ϣ��!");
					throw new MsgException("1011");
				} else if((re.getPasscode().equals(register.getPasscode()))&&(now - re.getUpdatetime().getTime())>1000*60*15){
					//throw new MsgException("��֤�볬ʱ!");
					throw new MsgException("1012");
				}else{
					//throw new MsgException("��֤�����!");
					throw new MsgException("1013");
				}
			}
		}

	}

}
