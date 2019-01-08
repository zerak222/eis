package com.planon.ped.common;

import java.sql.SQLException;
import java.util.List;

import com.planon.ped.dto.EmployeeData;

public interface IAbstractService {

	EmployeeData getEmployeeDetails(int aEmployeeCode) throws SQLException;

	List<EmployeeData> getEmployeesOfTheTeam(int aTeamCode) throws SQLException;
	
	List<EmployeeData> getListOfAllEmployees() throws SQLException;

}
