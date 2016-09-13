package com.car.web.maintain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.car.domain.CarMaintainInfo;
import com.car.domain.SimpleInfo;
import com.car.factory.BasicFactory;
import com.car.service.CarMaintainInfoService;
import com.car.util.DateFormatUtil;

public class SupplyMaintainInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarMaintainInfoService service = BasicFactory.getFactory().getInstance(CarMaintainInfoService.class);
		String count = request.getParameter("count");
		String carnumber = request.getParameter("carnumber");
		//String carnumber = "À’H123456";
		//System.out.println(carnumber);
		CarMaintainInfo c;
		
		List<SimpleInfo> ls = new ArrayList<SimpleInfo>();
		List<CarMaintainInfo> list = service.queryInfoByCount(carnumber,count);
		for(int i=0; i<list.size(); i++){
			SimpleInfo s = new SimpleInfo();
			c = list.get(i);
			s.setCarenginstate(c.getCarenginstate()) ;
			s.setCarlightstate(c.getCarlightstate());
			s.setCarmileage(c.getCarmileage());
			s.setCaroil(c.getCaroil());
			s.setCartranstate(c.getCartranstate());
			s.setTime(DateFormatUtil.getTime(c.getUpdatetime().getTime()));
			s.setPhone(c.getPhone());
			ls.add(s);
		}
		JSONArray array = JSONArray.fromObject(ls);
		response.getWriter().write(array.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
