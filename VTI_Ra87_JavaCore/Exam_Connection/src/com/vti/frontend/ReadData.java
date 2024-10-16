package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
	public static void main(String[] args) {
//		String url = "jdbc:mysql://127.0.0.1:3306/railway87";
		String url = "jdbc:mysql://localhost:3306/railway87";
		String username = "root";
		String password = "root";

		Connection myConn;
		try {
			myConn = DriverManager.getConnection(url, username, password);
			if (myConn != null) {
				System.out.println("Kết nối thành công!");
				Statement st = myConn.createStatement(); // tạo đối tượng statement để có thể truy vấn, update...
				// truy vấn dữ liệu từ bảng user -read data
				String sql = "select * from users"; // khởi tạo biến sql là câu lệnh truy vấn Mysql Select * from
				ResultSet rs = st.executeQuery(sql); // hứng kết quả
				while (rs.next()) {
					int id = rs.getInt("id");
					String us = rs.getString("username");
					System.out.println("user" + id + " " + us); // in dữ liệu ra từ DB
				}
				myConn.close();
			} else {
				System.out.println("Kết nối không thành công.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
