package com.car.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.domain.Register;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.RegisterService;
import com.car.util.SendPassCodeUtils;
import com.taobao.api.ApiException;

public class GetPassCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		try {
			RegisterService service = BasicFactory.getFactory().getInstance(RegisterService.class);
			String phone = request.getParameter("phone");
			System.out.println(phone);
			
			Register register = new Register();
			register.setPhone(phone);	
			service.addRegister(register);
		 
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
