package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.dto.Employee;

@WebServlet("/GetAllFarmersServlet")
public class GetAllFarmersServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    EmployeeDao employeeDao = new EmployeeDao();
	    List<Employee> empList = employeeDao.getEmployee();
	    
		if(empList != null) {
			request.setAttribute("empList", empList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayAll.jsp");
			requestDispatcher.include(request, response);
		}
		else {
			out.print("<h3><center>Record not found</center></h3>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
