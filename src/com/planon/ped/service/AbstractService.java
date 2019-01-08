package com.planon.ped.service;

import java.sql.SQLException;
import java.util.List;

import com.planon.ped.common.IAbstractService;
import com.planon.ped.dao.EmployeeDaoIMPL;
import com.planon.ped.dto.*;

abstract public class AbstractService implements IAbstractService {

	@Override
	public EmployeeData getEmployeeDetails(int aEmployeeCode) throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		return employeeDao.getEmployeeDetails(aEmployeeCode);
	}

	@Override
	public List<EmployeeData> getEmployeesOfTheTeam(int aTeamCode) throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		return employeeDao.getEmployeesOfTeam(aTeamCode);
	}

	@Override
	public List<EmployeeData> getListOfAllEmployees() throws SQLException {
		EmployeeDaoIMPL employeeDao = new EmployeeDaoIMPL();
		return employeeDao.getListOfAllEmployees();

	}
}
