package com.car.web.write;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.car.domain.CarBaseInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarBaseInfoService;

public class SupplyCarBaseInfoByCarNumber extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carnumber = request.getParameter("carnumber");
		//String carnumber = "À’H123456";
		CarBaseInfoService service = BasicFactory.getFactory().getInstance(CarBaseInfoService.class);
		CarBaseInfo info = service.findInfoByCarNumber(carnumber);
		System.out.println("carnumber="+carnumber);
		JSONObject obj = JSONObject.fromObject(info);
		response.getWriter().write(obj.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
