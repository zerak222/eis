package com.planon.ped.controller.employee;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.planon.ped.dao.EmployeeDaoIMPL;



/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		try {
			employeeDao.deleteEmployee(id);
			response.sendRedirect("ShowEmployeeList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	 // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }
}
