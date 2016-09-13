package com.car.web.maintain;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.domain.CarMaintainInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarMaintainInfoService;

public class MaintainCarMaintainInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarMaintainInfoService service = BasicFactory.getFactory().getInstance(CarMaintainInfoService.class);
		try {
			CarMaintainInfo maintain = new CarMaintainInfo();
			BeanUtils.populate(maintain, request.getParameterMap());
			int t = service.addInfo(maintain);
			//System.out.println("t="+t);
			response.getWriter().write(t+"");
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
