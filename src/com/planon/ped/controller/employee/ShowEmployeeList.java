package com.planon.ped.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out=response.getWriter();  
        out.println("<a href='AddEmployee.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Designation</th><th>Email</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>");  
        for(EmployeeData e:allEmployeesList){  
         out.print("<tr><td>"+e.getCode()+"</td><td>"+e.getName()+"</td><td>"+e.getDesignation()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td><a href='UpdateEmployee?id="+e.getCode()+"'>edit</a></td><td><a href='DeleteEmployee?id="+e.getCode()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>"); 

        out.close();  
		}
	 // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      doGet(request, response);
	   }
}
