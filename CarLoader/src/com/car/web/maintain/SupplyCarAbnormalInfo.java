package com.car.web.maintain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.car.domain.CarAbnormalInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarAbnormalInfoService;

public class SupplyCarAbnormalInfo extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		CarAbnormalInfoService service = BasicFactory.getFactory().getInstance(CarAbnormalInfoService.class);
		List<CarAbnormalInfo> list = service.queryByPhone(phone);
		JSONArray array = JSONArray.fromObject(list);
		response.getWriter().write(array.toString());	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
