package com.planon.ped.controller.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planon.ped.dto.EmployeeData;
import com.planon.ped.service.employee.EmployeeService;

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
		
		List<EmployeeData> allEmployeesList = null;
		try {
			EmployeeService empServices = new EmployeeService();
			allEmployeesList = empServices.getListOfAllEmployees();
		} catch (SQLException e) {
			throw new ServletException(e.getMessage()); 
		}
		response.setContentType("text/html");  
        request.setAttribute("allEmployeesList", allEmployeesList);
        getServletConfig().getServletContext().getRequestDispatcher("/ShowEmployeeList.jsp").forward(request, response);

		}
	 // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }
}
