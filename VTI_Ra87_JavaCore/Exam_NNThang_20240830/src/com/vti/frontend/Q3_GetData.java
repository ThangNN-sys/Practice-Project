package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q3_GetData {
	public static void main(String[] args) {
		// khối lệnh để kết nối tới DB trong MySQL
		String url = "jdbc:mysql://localhost:3306/quan_ly_user";
		String username = "root";
		String password = "root";

		Connection myConn;
		try {
			myConn = DriverManager.getConnection(url, username, password);
			if (myConn != null) {
				System.out.println("Kết nối thành công!");
				Statement st = myConn.createStatement(); // tạo đối tượng statement để có thể truy vấn, update...
				// truy vấn dữ liệu từ bảng user -read data
				String sql = "select * from user where `role` = 'manager'"; // khởi tạo biến sql là câu lệnh truy vấn
																			// Mysql Select * from
				ResultSet rs = st.executeQuery(sql); // hứng kết quả
				System.out.println("Danh sách Manager:");
				System.out
						.println("----------------------------------------------------------------------------------");
				System.out
						.println("|user id|full_name|email            |password  |exp_in_year|pro_skill|project_id |");
				System.out
						.println("----------------------------------------------------------------------------------");
				while (rs.next()) {
					int id = rs.getInt("id");
					String fn = rs.getString("full_name");
					String em = rs.getString("email");
					String pw = rs.getString("password");
					String ex = rs.getString("exp_in_year");
					String ps = rs.getString("pro_skill");
					String pi = rs.getString("project_id");
					// in dữ liệu ra từ DB
					System.out.println("| " + id + "     |" + fn + "    |" + em + "  | " + pw + "  | " + ex
							+ "         | " + ps + "    | " + pi + "|");

				}
				System.out
						.println("----------------------------------------------------------------------------------");
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
