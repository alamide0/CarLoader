package com.car.util;

import java.util.Random;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SendPassCodeUtils {
	private SendPassCodeUtils(){
		
	}
	
	public static String sendPassCode(String phone) throws ApiException{
		String url="http://gw.api.taobao.com/router/rest";
		String appkey="23327377";
		String secret="632b27716b014d27bec1fd252922c09d";
		//����ģ�������
		//String json="{'code':'33565','product':'����С��'}";
		String passCode = createPassCode();
		System.out.println(passCode);
		//�𾴵��û������ã�����С�Ӹ�����������֤����${passcode}����ȥע��ɣ���
		String json="{'passcode':'"+passCode+"'}";
		System.out.println(json);
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("����С��");
		req.setSmsParamString(json);
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_6725740");
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		//System.out.println(rsp.getBody());
		return passCode;

	}
	
	public static String createPassCode(){
		StringBuffer buffer = new StringBuffer();
		Random rand = new Random();
		for(int i=0; i<6; i++){
			buffer.append(Math.abs((rand.nextInt()%9)));
		}
		return buffer.toString();
	}
}
