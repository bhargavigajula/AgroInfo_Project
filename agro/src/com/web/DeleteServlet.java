package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.EmployeeDao;
import com.dto.Employee;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String farmerName = request.getParameter("farmerName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDao employeeDao = new EmployeeDao(); 
		int x = employeeDao.delete(farmerName);

		if(x > 0){
			RequestDispatcher rd = request.getRequestDispatcher("GetAllFarmersServlet");
			rd.forward(request, response);


		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
