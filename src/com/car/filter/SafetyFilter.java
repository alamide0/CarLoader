package com.car.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.domain.User;
import com.car.factory.BasicFactory;

import com.car.service.UserService;
import com.car.service.UserSignlLoginService;

public class SafetyFilter implements Filter {

	private UserService service = BasicFactory.getFactory().getInstance(
			UserService.class);
	private UserSignlLoginService lservice = BasicFactory.getFactory()
			.getInstance(UserSignlLoginService.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		StringBuffer url = req.getRequestURL();
		System.out.println(url);
		String[] strs = url.toString().split("/");
		// System.out.println(req.getParameter("carnumber") + "123");
		//在这几种情况下，不用去检验，那么又如何保证数据安全呢？首先在这几种情况下只有ReSetPasswordServlet涉及
		//到用户安全而这种情况下是要检验验证码的，所以不会产生安全问题
		if (!url.toString().contains("servlet")||url.toString().contains("ReSetPasswordServlet")
				||url.toString().contains("CheckPCodeServlet")||url.toString().contains("ForgetPwdServlet")) {
			chain.doFilter(req, resp);
			// System.out.println("66");
			return;
		}

		String token = req.getParameter("token");
		String phone = req.getParameter("phonefilter");
		String password = req.getParameter("passwordfilter");
		User user = new User();
		user.setPhone(phone);
		user.setPassword(password);
		// System.out.println("phone="+phone+"pwd="+password);
		// System.out.println(token);
		String code = service.findUserFilter(user);
		if(code.equals("1000")){
			chain.doFilter(req, resp);
			// System.out.println("66");
			return;
		}
		if (!code.equals("1005")) {
			resp.getWriter().write("0001");// 密码错误
			return;
		}

		// System.out.println(strs[strs.length-1]);
		String onlyCode = lservice.query(phone);
		if (!strs[strs.length - 1].equals("UserSignlLoginServlet")
				&& !strs[strs.length - 1].equals("LoginServlet")&& !strs[strs.length - 1].equals("SupplyNickNameServlet")
				&& !onlyCode.equals("")) {
			if (!onlyCode.equals(token)) {
				resp.getWriter().write("0002");// 登陆过期
				return;
			}
		}
		// System.out.println(url);
		chain.doFilter(req, resp);
		// System.out.println("==========");
		// System.out.println(new String((req.getParameter("carnumber") + "123")
		// .getBytes("iso-8859-1"), "utf-8"));
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
