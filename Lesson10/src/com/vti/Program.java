package com.vti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) {
//		String url = "jdbc:mysql://127.0.0.1:3306/testing_system";
		String url = "jdbc:mysql://localhost:3306/railway87";
		String username = "root";
		String password = "root";

		Connection myConn;
		try {
			myConn = DriverManager.getConnection(url, username, password);
			if (myConn != null) {
				System.out.println("Kết nối thành công");
				Statement st = myConn.createStatement();
				String sql = "select * from users";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt(username);
					System.out.println("user" + id + " " + rs);

				}

			} else {
				System.out.println("Kết nối không thành công");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
