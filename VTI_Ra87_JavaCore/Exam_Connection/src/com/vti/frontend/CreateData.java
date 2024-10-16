package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateData {
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
				// nhập dữ liệu vào bảng user - create data
				String sql = "INSERT INTO users (id, username)" + "VALUES (?, ?)";
				PreparedStatement preparedStatementCr = myConn.prepareStatement(sql);
				int id = 10;
				String username1 = "USER006";
				preparedStatementCr.setLong(1, id);
				preparedStatementCr.setString(2, username1);
				int effectedRecordAmountCr = preparedStatementCr.executeUpdate();
				System.out.println("Số bản ghi đã được thêm vào: " + effectedRecordAmountCr);
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
