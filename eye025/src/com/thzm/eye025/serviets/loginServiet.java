package com.thzm.eye025.serviets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzm.eye025.bean.Sysadmin;
import com.thzm.eye025.service.UserService;

@WebServlet("/login")
public class loginServiet implements Servlet{
	private String contentType ;
	

	
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType(this.contentType);
		
		String adminName = request.getParameter("adminName"); // 获取用户发送的请求参数
		String password = request.getParameter("password");
		//=================================================
		
		HttpServletRequest req = (HttpServletRequest) request;
	
	
		
		
		//==================================================
		boolean ok = true;
		
		Sysadmin user = null;
		
		try {
			user = UserService.login(adminName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			ok =false;
		}
		System.out.println("----------- 我可以为你进行登录服务------------");
		if(!ok) {
			response.getWriter().print(" 服务器出现错误。 "); // 响应。输出给浏览器的内容。
			
		}
		else {
			if(user != null) {// 登录成功
				//自动登录处理
				String auto=request.getParameter("autoLogin");
				if("on".equals(auto)) {
					Cookie c1=new Cookie("adminName",adminName);
					Cookie c2=new Cookie("password",password);
					c1.setMaxAge(60*60*24*10);
					
					c2.setMaxAge(60*60*24*10);
					
					HttpServletResponse res = (HttpServletResponse) response;
					res.addCookie(c1);
					res.addCookie(c2);
				}
				

				
				
				
				// 获取用户的Session 对象。
				HttpSession session = req.getSession(true);
				// 把用户信息放到Session 中。
				session.setAttribute("userInfo", user);
				
				HttpServletResponse res=(HttpServletResponse)response;
				res.sendRedirect("./adminmy.jsp");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("adminmy.html"); // 获取一个请求转发对象。
//				dispatcher.forward(request, response); // 前进。（ 转发）
//				
				//response.getWriter().print(" login success. "+ user.getName()); // 响应。输出给浏览器的内容。
			}else { // 登录失败
				//response.getWriter().print(" user name or password error. "); // 响应。输出给浏览器的内容。
				request.setAttribute("msg", "用户名或密码不正确。");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("============将要关闭=============");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("============getServletConfig中=============");
		
		
		
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("============getServletInfo中=============");
		return null;
	}

	



}