package com.planon.ped.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.planon.ped.db.DBConnection;
import com.planon.ped.dto.EmployeeData;

public class EmployeeDaoIMPL {

	public void createEmployee(EmployeeData aEmployee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"insert into EMPLOYEE(NAME,EMAIL,PHONE,GENDER,DOB,DESIGNATION,LOCATION) values(?,?,?,?,?,?,?)");
			ps.setString(1, aEmployee.getName());
			ps.setString(2, aEmployee.getEmail());
			ps.setString(3, aEmployee.getPhone());
			ps.setString(4, aEmployee.getGender());
			ps.setDate(5, aEmployee.getDob());
			ps.setString(6, aEmployee.getDesignation());
			ps.setString(7, aEmployee.getLocation());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (!(ps == null)) {
				ps.close();
			}
		}
	}

	public void updateEmployeeDetails(EmployeeData aEmployee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"update EMPLOYEE set NAME=?,EMAIL=?,PHONE=?,GENDER=?,DOB=?,DESIGNATION=?,LOCATION=? where CODE=?");
			ps.setString(1, aEmployee.getName());
			ps.setString(2, aEmployee.getEmail());
			ps.setString(3, aEmployee.getPhone());
			ps.setString(4, aEmployee.getGender());
			ps.setDate(5, aEmployee.getDob());
			ps.setString(6, aEmployee.getDesignation());
			ps.setString(7, aEmployee.getLocation());
			ps.setInt(8, aEmployee.getCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (!(ps == null)) {
				ps.close();
			}
		}
	}

	public void deleteEmployee(int aEmpCode) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from EMPLOYEE where CODE=?");
			ps.setInt(1, aEmpCode);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (!(ps == null)) {
				ps.close();
			}
		}
	}
	
	public List<EmployeeData> getListOfAllEmployees() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmployeeData> allEmployeesList = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select CODE,NAME,DESIGNATION,EMAIL,PHONE from EMPLOYEE ");
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeData employee = new EmployeeData();
				employee.setCode(rs.getInt("CODE"));
				employee.setName(rs.getString("NAME"));
				employee.setDesignation(rs.getString("DESIGNATION"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setPhone(rs.getString("PHONE"));
				allEmployeesList.add(employee);
			}
		} catch (SQLException e) {
		} finally {
			if ((ps != null) && (rs != null)) {
				ps.close();
				rs.close();
			}
		}
		return allEmployeesList;
	}
	
}
