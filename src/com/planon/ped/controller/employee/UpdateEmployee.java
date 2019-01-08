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
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
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
        
        EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
        try {
			EmployeeData e = employeeDao.getEmployeeDetails(id);
			 out.print("<form action='UpdateEmployee2' method='post'>");  
		        out.print("<table>");  
		        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getCode()+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
		        out.print("<tr><td>Designation:</td><td><input type='text' name='designation' value='"+e.getDesignation()+"'/></td></tr>");
		        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
		        out.print("<tr><td>Phone Number:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/></td></tr>");
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");  
		          
		        out.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
	}
	 // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }

}

