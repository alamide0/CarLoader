package com.car.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.domain.ForgetPwd;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.ForgetPwdService;

public class ForgetPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForgetPwdService service = BasicFactory.getFactory().getInstance(ForgetPwdService.class);
		try {
			ForgetPwd forget = new ForgetPwd();
			BeanUtils.populate(forget, request.getParameterMap());
			service.addFor(forget);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (MsgException e) {
			response.getWriter().write(e.getMessage());
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
