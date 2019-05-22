package com.planon.ped.controller.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planon.ped.common.IEmployeeService;
import com.planon.ped.dto.EmployeeData;
import com.planon.ped.service.employee.EmployeeService;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String designation = request.getParameter("designation");
		String location = request.getParameter("location");
		try {
			String dateformat = "MM/dd/yyyy";
			if (dob.indexOf("-") > 0) {
				dateformat = "dd-MM-yy";
			}

			SimpleDateFormat df = new SimpleDateFormat(dateformat);
			java.util.Date dateOfBirth = df.parse(dob);

			EmployeeData employee = new EmployeeData();
			employee.setName(name);
			employee.setEmail(email);
			employee.setPhone(phone);
			employee.setGender(gender);
			employee.setDob(new java.sql.Date(dateOfBirth.getTime()));
			employee.setDesignation(designation);
			employee.setLocation(location);

			IEmployeeService employeeService = new EmployeeService();
			employeeService.updateEmployeeDetails(employee);

		} catch (SQLException | ParseException e) {
			String message = "Record has not updated!!!";
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(message);
			throw new ServletException(e.getMessage());
		}

		String text = "Record has been succesfully updated!!!";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(text);

	}

}
