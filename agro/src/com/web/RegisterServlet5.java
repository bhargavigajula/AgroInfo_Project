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

@WebServlet("/RegisterServlet5")
public class RegisterServlet5 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		
		Employee employee = new Employee(userName,password,designation);
		EmployeeDao employeeDao = new EmployeeDao();
		int result = employeeDao.register(employee);
		
		if(result > 0) {
			if(designation.equalsIgnoreCase("employee")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeProfile.html");			
				requestDispatcher.include(request, response);
			}
			if(designation.equalsIgnoreCase("user")){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserProfile.html");			
				requestDispatcher.include(request, response);
			}
		} else {
			out.println("<p><center>Registration Failed!!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");			
			requestDispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
