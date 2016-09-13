package com.car.web.oil;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.domain.CarOilOrderBaseInfo;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.CarOilOrderBaseInfoService;

public class CarOilOrderBaseIndoAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarOilOrderBaseInfoService service = BasicFactory.getFactory().getInstance(CarOilOrderBaseInfoService.class);
		
		try {
			CarOilOrderBaseInfo info = new CarOilOrderBaseInfo();
			BeanUtils.populate(info, request.getParameterMap());
			service.add(info);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
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
