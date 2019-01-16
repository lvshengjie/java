package com.thzm.eye025.serviets.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thzm.eye025.bean.Abstract;
import com.thzm.eye025.service.AbstaractService;

@WebServlet("/showAbstract")
public class ShowAbstractServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json="{}";
		try {
			Abstract abs = AbstaractService.getAbstract();
			if(abs!=null) {
//				json="{\"p1\":\""+abs.getPicture1()+"\", \"p2\":\""+abs.getPicture2()+"\", \"p3\":\""
//			             +abs.getPicture3()+"\",\"content\":\""+abs.getContent()+"\"}";
				
				ObjectMapper mapper=new ObjectMapper();
				json= mapper.writeValueAsString(abs);
				
				System.out.println(json);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Content-type", "application/json; charset=utf-8");
		
		PrintWriter out=response.getWriter();
		out.print(json);
		}


}
