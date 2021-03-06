package com.thzm.eye025.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thzm.eye025.bean.Sysadmin;
import com.thzm.eye025.service.UserService;


//@WebFilter("/*")
public class AccessFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		String scheme=req.getScheme();//http或者https
		String host=req.getLocalName();//主机号
		int port=req.getLocalPort();//服务器端口
		String ctxPth = req.getContextPath();//根路径
		String url = scheme+"://"+host+":"+port+ctxPth;
		
		String path = req.getServletPath();//获取与url中匹配的路径
		
		HttpSession session=req.getSession(true);
		Object o=session.getAttribute("userInfo");
		
		if(o!=null) {//已登陆
			chain.doFilter(request, response); // 放行
		}else {//没登录
			if(-1 != path.indexOf("index.jsp") || -1!=(path.indexOf("login"))|| -1!=(path.indexOf("showAbstract"))) {
				chain.doFilter(request, response); // 放行
		}else {
			Cookie[] cks = req.getCookies();
			Map<String, String> map = new HashMap<>();
			for(Cookie c : cks) {
				map.put(c.getName(), c.getValue());
			}try {
				Sysadmin u = UserService.login(map.get("adminName"), map.get("password"));
				session.setAttribute("userInfo", u);
				if(u!=null) {
					res.sendRedirect(url+"/adminmy.jsp");
				}else {
					res.sendRedirect(url);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void destroy() {
		
	}

}
