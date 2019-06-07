package com.planon.ped.service;

import java.sql.SQLException;
import java.util.List;

import com.planon.ped.common.IEmployeeService;
import com.planon.ped.dao.EmployeeDaoIMPL;
import com.planon.ped.dto.EmployeeData;

public class EmployeeService  implements IEmployeeService{

	@Override
	public List<EmployeeData> getListOfAllEmployees() throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		return employeeDao.getListOfAllEmployees();

	}
	
	@Override
	public void createEmployee(EmployeeData aEmployee) throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		employeeDao.createEmployee(aEmployee);
	}

	@Override
	public void updateEmployeeDetails(EmployeeData aEmployee) throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		employeeDao.updateEmployeeDetails(aEmployee);
	}

	@Override
	public void deleteEmployee(int aEmployeeCode) throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		employeeDao.deleteEmployee(aEmployeeCode);
	}
}
