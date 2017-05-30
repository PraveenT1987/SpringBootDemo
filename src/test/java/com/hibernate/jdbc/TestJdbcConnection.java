package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbcConnection {

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("oracle.jdbc.OracleDriver");

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "ravi";
		String pass = "ravi123";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			PreparedStatement ps = myConn.prepareStatement("select * from country");
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count != 0) {
				System.out.println("Found total rows '" + rs.getInt(1) + "' in table Country!");
			}
			System.out.println("Connection successful!!!");

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
