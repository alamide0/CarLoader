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
import com.car.domain.CarOilOrderInfo;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.CarOilOrderInfoService;

public class CarOilOrderInfoStorageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarOilOrderInfoService service = BasicFactory.getFactory().getInstance(CarOilOrderInfoService.class);
		try {
			CarOilOrderInfo info = new CarOilOrderInfo();
			BeanUtils.populate(info, request.getParameterMap());
			
			service.storage(info);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (MsgException e) {
			response.getWriter().write(e.getMessage());
			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
