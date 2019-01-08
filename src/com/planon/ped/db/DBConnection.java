package com.planon.ped.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con = null;
	public static final String URL = "jdbc:sqlserver://" + "pc13099" + ":" + 1433 + ";" + "databaseName=" + "PEM"
			+ ";username=" + "PEM" + ";password=" + "Plan$QL" + ";";

	public static Connection getConnection() {

		if (con != null) {
			return con;
		}

		return createConnection();
	}

	public static Connection createConnection() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(URL);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return con;
	}
}
