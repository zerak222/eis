package com.planon.ped.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planon.ped.common.IEmployeeService;
import com.planon.ped.dto.EmployeeData;
import com.planon.ped.service.EmployeeService;

/**
 * Servlet implementation class ShowEmployeeList
 */
@WebServlet("/ShowEmployeeList")
public class ShowEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		List<EmployeeData> allEmployeesList = null;
		try {
			IEmployeeService empServices = new EmployeeService();
			allEmployeesList = empServices.getListOfAllEmployees();
		} catch (SQLException e) {
			throw new ServletException(e.getMessage()); 
		}
		response.setContentType("application/json");  
		String json = gson.toJson(allEmployeesList);
		response.getWriter().write(json);
		}
	 // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }
}
