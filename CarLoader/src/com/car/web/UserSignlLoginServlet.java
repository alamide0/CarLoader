package com.car.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.domain.UserSignlLogin;
import com.car.factory.BasicFactory;
import com.car.service.UserSignlLoginService;

public class UserSignlLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserSignlLoginService service = BasicFactory.getFactory().getInstance(UserSignlLoginService.class);
		try {
			UserSignlLogin info = new UserSignlLogin();
			BeanUtils.populate(info, request.getParameterMap());
			service.add(info);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
