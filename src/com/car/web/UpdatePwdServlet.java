package com.car.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.domain.User;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.UserService;

public class UpdatePwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = BasicFactory.getFactory().getInstance(
				UserService.class);
		try {
			User user = new User();
			String username = request.getParameter("username");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String olderPwd = request.getParameter("olderpwd");

			// System.out.println(phone+":"+password+":"+username+":"+olderPwd);
			user.setPassword(password);
			user.setUsername(username);
			user.setPhone(phone);
			//System.out.println("============"+phone);
			if (password.length() > 0) {
				service.updatePwd(user, olderPwd);
			}
			if(username.length()>0){
				service.updateName(user);
			}
			
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
