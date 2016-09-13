package com.car.web.oil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.car.factory.BasicFactory;
import com.car.service.CarOilOrderBaseInfoService;

public class CarOilOrderBaseInfoQuery extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarOilOrderBaseInfoService service = BasicFactory.getFactory().getInstance(CarOilOrderBaseInfoService.class);
		String phone = request.getParameter("phone");
		List<String> list = service.queryCarNumberByPhone(phone);
		JSONArray array = JSONArray.fromObject(list);
		response.getWriter().write(array.toString());
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
