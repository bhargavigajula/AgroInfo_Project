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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String farmerName = request.getParameter("farmerName");
		String location = request.getParameter("location");
		String mandal = request.getParameter("mandal");
		String district = request.getParameter("district");
		String product = request.getParameter("product");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String farmerMobileNo = request.getParameter("farmerMobileNo");

		Employee employee = new Employee(farmerName,location,mandal,district,product,quantity,farmerMobileNo);
		EmployeeDao employeeDao = new EmployeeDao();
		int result = employeeDao.update(employee);

		if(result > 0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetAllFarmersServlet");
			requestDispatcher.include(request, response);
		}
		else{
			out.println("<p><center>Updation Failed!!</center></p>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetAllFarmersServlet");
			requestDispatcher.include(request, response);
		}

		out.println("</html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
