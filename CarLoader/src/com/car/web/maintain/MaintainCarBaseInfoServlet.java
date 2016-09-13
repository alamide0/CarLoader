package com.car.web.maintain;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.car.dao.CarBaseInfoDao;
import com.car.domain.CarBaseInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarBaseInfoService;

public class MaintainCarBaseInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarBaseInfoService service = BasicFactory.getFactory().getInstance(CarBaseInfoService.class);
		try {
			//System.out.println("here come");
			CarBaseInfo base = new CarBaseInfo();
			BeanUtils.populate(base, request.getParameterMap());
			//System.out.println(base.getPhone()+"44444");
			service.addInfo(base);
			response.getWriter().write("2001");	
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			response.getWriter().write("2002");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			response.getWriter().write("2002");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
