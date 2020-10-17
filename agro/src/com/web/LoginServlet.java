package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.dto.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");

		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);
		session.setAttribute("designation", designation);

		EmployeeDao employeeDAO = new EmployeeDao();
		Employee employee = employeeDAO.getEmployee(userName,password,designation);
		if(employee != null) {

			session.setAttribute("employee", employee);

			if(designation.equalsIgnoreCase("employee")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeProfile.html");			
				requestDispatcher.forward(request, response);
			}
			if(designation.equalsIgnoreCase("user")){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserProfile.html");			
				requestDispatcher.forward(request, response);
			}
		}
		else {
			out.println("<p><center>Invalid Credentials</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Enter.html");
			requestDispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}