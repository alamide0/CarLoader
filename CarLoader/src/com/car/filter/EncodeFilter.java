package com.car.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.car.domain.User;
import com.car.exception.MsgException;
import com.car.factory.BasicFactory;
import com.car.service.UserService;
import com.car.service.UserSignlLoginService;

public class EncodeFilter implements Filter {
	private String encode = null;
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		resp.setCharacterEncoding(encode);
		resp.setContentType("text/html;chartset="+encode);
		//resp.getWriter().write("ÃÜÂë´íÎó");
//		StringBuffer url = req.getRequestURL();
//		System.out.println(url);
//		String[] strs = url.toString().split("/");
//		System.out.println(req.getParameter("carnumber")+"123");
//		if(!url.toString().contains("servlet")){
//			chain.doFilter(new MyHttpServletRequest(req), resp);
//			System.out.println("66");
//			return;
//		}
//		
//		String token = req.getParameter("token");
//		String phone = req.getParameter("phonefilter");
//		String password = req.getParameter("passwordfilter");
//		User user = new User();
//		user.setPhone(phone);
//		user.setPassword(password);
//		//System.out.println("phone="+phone+"pwd="+password);
//		//System.out.println(token);
//		String code = service.findUserFilter(user);
//		if(!code.equals("1005")){
//			resp.getWriter().write("0001");//ÃÜÂë´íÎó
//			return ;
//		}
//		
//		
//		//System.out.println(strs[strs.length-1]);
//		String onlyCode = lservice.query(phone);
//		if(!strs[strs.length-1].equals("UserSignlLoginServlet")&&!strs[strs.length-1].equals("LoginServlet")&&!onlyCode.equals("")){
//			if(!onlyCode.equals(token)){
//				resp.getWriter().write("0002");//µÇÂ½¹ýÆÚ
//				return;
//			}
//		}
//		System.out.println(url);
		chain.doFilter(new MyHttpServletRequest(req), resp);
		
		
	}

	private class MyHttpServletRequest extends HttpServletRequestWrapper {
		private HttpServletRequest req = null;
		private boolean tag = true;
		
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			req = request;
			
		}

		@Override
		public Map<String,String[]> getParameterMap() {
			
			//req.get
			try {
				if (req.getMethod().equals("POST")) {
					req.setCharacterEncoding(encode);////
					System.out.println(encode);
//				req.getParameterMap().remove("phonefilter");
//				req.getParameterMap().remove("token");
//				req.getParameterMap().remove("passwordfilter");
					return req.getParameterMap();
				} else if (req.getMethod().equals("GET")) {
					Map<String, String[]> map = req.getParameterMap();
					if (tag) {
						for (Map.Entry<String, String[]> entry : map.entrySet()) {
							
							String[] value = entry.getValue();
							for (int i = 0; i < value.length; i++) {
								value[i] = new String(value[i]
										.getBytes("iso8859-1"), encode);
								//System.out.println(value[i]);
							}
						}
						tag = false;
					}
//					req.getParameterMap().remove("phonefilter");
//					req.getParameterMap().remove("token");
//					req.getParameterMap().remove("passwordfilter");
					return map;
				} else {
//					req.getParameterMap().remove("phonefilter");
//					req.getParameterMap().remove("token");
//					req.getParameterMap().remove("passwordfilter");
					return super.getParameterMap();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return super.getParameterMap();

		}
		
		

		@Override
		public String getParameter(String name) {
			return this.getParameterValues(name)==null?null:this.getParameterValues(name)[0];
		}

		@Override
		public String[] getParameterValues(String name) {
			return  this.getParameterMap().get(name);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getServletContext().getInitParameter("encode");
	}

}
