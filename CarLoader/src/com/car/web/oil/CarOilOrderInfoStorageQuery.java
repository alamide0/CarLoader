package com.car.web.oil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.car.domain.CarOilOrderInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarOilOrderInfoService;

public class CarOilOrderInfoStorageQuery extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarOilOrderInfoService service = BasicFactory.getFactory().getInstance(CarOilOrderInfoService.class);
		String phone = request.getParameter("phone");
		List<CarOilOrderInfo> list = service.query(phone);
		JSONArray array = JSONArray.fromObject(list);
		response.getWriter().write(array.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
