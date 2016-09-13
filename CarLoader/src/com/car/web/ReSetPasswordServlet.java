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
import com.car.domain.User;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.ForgetPwdService;

public class ReSetPasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ForgetPwdService service = BasicFactory.getFactory().getInstance(
				ForgetPwdService.class);
		User user = new User();
		ForgetPwd forget = new ForgetPwd();
		String passcode = request.getParameter("passcode");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		user.setPassword(password);
		user.setPhone(phone);
		
		forget.setPhone(phone);
		forget.setPasscode(passcode);
		
		try {
			service.updatePwd(forget,user);
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
