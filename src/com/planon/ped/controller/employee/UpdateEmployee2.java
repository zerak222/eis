package com.planon.ped.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.planon.ped.dao.EmployeeDaoIMPL;
import com.planon.ped.dto.EmployeeData;

/**
 * Servlet implementation class UpdateEmployee2
 */
@WebServlet("/UpdateEmployee2")
public class UpdateEmployee2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid); 
        
        String name=request.getParameter("name");  
        String designation=request.getParameter("designation");  
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        
        EmployeeData e = new EmployeeData();
        e.setCode(id);  
        e.setName(name);  
        e.setDesignation(designation); 
        e.setEmail(email);
        e.setPhone(phone);
        
        EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
        try {
			employeeDao.updateEmployeeDetails(e);
			 response.sendRedirect("ShowEmployeeList");  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        out.close();  
      
	}
	 // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }
}

