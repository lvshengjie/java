package com.thzm.eye025.serviets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzm.eye025.service.AbstaractService;


@WebServlet("/delAbs")
public class DelAbsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId= request.getParameter("absId");
		int id = Integer.parseInt(strId);
		
		try {
			AbstaractService.delByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/abstractList").forward(request, response);
	}

}