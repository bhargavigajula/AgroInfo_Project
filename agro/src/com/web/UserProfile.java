package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.dto.Employee;

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String customerName = request.getParameter("customerName");
		String location = request.getParameter("location");
		String mandal = request.getParameter("mandal");
		String district = request.getParameter("district");
		String product = request.getParameter("product");
		int  quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Employee employee = new Employee(customerName,location,mandal,district,product,quantity);
		EmployeeDao employeeDao = new EmployeeDao();
		int result = employeeDao.User(employee);
		
		if(result > 0) {
			EmployeeDao employeeDao1 = new EmployeeDao();
			List<Employee> empList = employeeDao1.getEmployee1(product,mandal);
			System.out.println(empList);
			if(empList != null) {
				request.setAttribute("empList", empList);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayFarmer.jsp");
				requestDispatcher.include(request, response);
			}
			else {
				out.print("<h3><center>Record not found</center></h3>");
			}
			
		} else {
			out.println("<p><center>Profile Updation Failed!!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.html");			
			requestDispatcher.include(request, response);
		}

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
