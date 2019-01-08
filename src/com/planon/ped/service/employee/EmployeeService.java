package com.planon.ped.service.employee;

import java.sql.SQLException;

import com.planon.ped.common.IEmployeeService;
import com.planon.ped.dao.EmployeeDaoIMPL;
import com.planon.ped.dto.EmployeeData;
import com.planon.ped.service.AbstractService;

public class EmployeeService extends AbstractService implements IEmployeeService{

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
