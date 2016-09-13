package com.car.web.write;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.car.domain.CarBaseInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarBaseInfoService;

public class SupplyCarBaseInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarBaseInfoService service = BasicFactory.getFactory().getInstance(CarBaseInfoService.class);
		String phone = request.getParameter("phone");
		List<CarBaseInfo> list = service.findInfoByPhone(phone);
		JSONArray array = JSONArray.fromObject(list);
		response.getWriter().write(array.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
