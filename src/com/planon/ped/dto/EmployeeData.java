package com.planon.ped.dto;

import java.sql.Date;

public class EmployeeData extends AbstractData{
	private int teamRef;
	private String phone;
	private String email;
	private String gender;
	private Date dob;
	private String designation;

	public int getTeamRef() {
		return teamRef;
	}

	public void setTeamRef(int teamRef) {
		this.teamRef = teamRef;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
