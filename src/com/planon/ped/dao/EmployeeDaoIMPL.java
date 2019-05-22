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
	public List<EmployeeData> getEmployeesOfTeam(int aTeamCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmployeeData> allEmployees = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from EMPLOYEE1 where TEAM_REF=?");
			ps.setInt(1, aTeamCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeData employee = new EmployeeData();
				employee.setCode(rs.getInt("CODE"));
				employee.setName(rs.getString("NAME"));
				allEmployees.add(employee);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if ((ps != null) && (rs != null)) {
				ps.close();
				rs.close();
			}
		}
		return allEmployees;
	}

	public void createEmployee(EmployeeData aEmployee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"insert into EMPLOYEE1(NAME,TEAM_REF,EMAIL,PHONE,GENDER,DOB,DESIGNATION,LOCATION) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, aEmployee.getName());
			ps.setInt(2, aEmployee.getTeamRef());
			ps.setString(3, aEmployee.getEmail());
			ps.setString(4, aEmployee.getPhone());
			ps.setString(5, aEmployee.getGender());
			ps.setDate(6, aEmployee.getDob());
			ps.setString(7, aEmployee.getDesignation());
			ps.setString(8, aEmployee.getLocation());
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
					"update EMPLOYEE1 set NAME=?,TEAM_REF=?,EMAIL=?,PHONE=?,GENDER=?,DOB=?,DESIGNATION=?,LOCATION=? where CODE=?");
			ps.setString(1, aEmployee.getName());
			ps.setInt(2, aEmployee.getTeamRef());
			ps.setString(3, aEmployee.getEmail());
			ps.setString(4, aEmployee.getPhone());
			ps.setString(5, aEmployee.getGender());
			ps.setDate(6, aEmployee.getDob());
			ps.setString(7, aEmployee.getDesignation());
			ps.setString(8, aEmployee.getLocation());
			ps.setInt(9, aEmployee.getCode());
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
			ps = con.prepareStatement("delete from EMPLOYEE1 where CODE=?");
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

	public EmployeeData getEmployeeDetails(int aEmployeeCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeData employeeData = new EmployeeData();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from EMPLOYEE1 where CODE=?");
			ps.setInt(1, aEmployeeCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				employeeData.setCode(rs.getInt("CODE"));
				employeeData.setName(rs.getString("NAME"));
				employeeData.setTeamRef(rs.getInt("TEAM_REF"));
				employeeData.setEmail(rs.getString("EMAIL"));
				employeeData.setPhone(rs.getString("PHONE"));
				employeeData.setGender(rs.getString("GENDER"));
				employeeData.setDob(rs.getDate("DOB"));
				employeeData.setDesignation(rs.getString("DESIGNATION"));
				employeeData.setLocation(rs.getString("LOCATION"));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if ((ps != null) && (rs != null)) {
				ps.close();
				rs.close();
			}
		}
		return employeeData;
	}
	
	public List<EmployeeData> getListOfAllEmployees() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmployeeData> allEmployeesList = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select CODE,NAME,DESIGNATION,EMAIL,PHONE from EMPLOYEE1 ");
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
