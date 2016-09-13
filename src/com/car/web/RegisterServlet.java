package com.car.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.domain.Register;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.RegisterService;

public class RegisterServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		RegisterService service = BasicFactory.getFactory().getInstance(RegisterService.class);
		
		try {
			Register register = new Register();
			BeanUtils.populate(register, request.getParameterMap());
			System.out.println(register.getPasscode());
			service.findRegisterByPhone(register);
			
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
