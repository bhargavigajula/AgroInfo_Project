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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String farmerName = request.getParameter("farmerName");
		out.println("<html>");
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.getEmployee(farmerName);
		request.setAttribute("employee",employee);
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.include(request,response);
		
		
		if(employee != null){
			
		}
		else{
			out.print("<h3><center>Record not Found</center></h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}