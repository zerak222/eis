package com.planon.ped.common;

import java.sql.SQLException;

import com.planon.ped.dto.EmployeeData;

public interface IEmployeeService {

	void createEmployee(EmployeeData aEmployee) throws SQLException;

	void updateEmployeeDetails(EmployeeData aEmployee) throws SQLException;

	void deleteEmployee(int aEmployeeCode) throws SQLException;
}
