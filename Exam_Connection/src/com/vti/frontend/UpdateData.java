package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
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
				// cập nhật dữ liệu vào bảng user - update data
				String sql = "update user " + "set username = ?" + "set password = ?" + "where id = ?";
				PreparedStatement preparedStatement = myConn.prepareStatement(sql);
				preparedStatement.setString(1, "USER001");
				preparedStatement.setString(2, "123456");
				int effectedRecordAmount = preparedStatement.executeUpdate();
				System.out.println("Số bản ghi đã được cập nhật: " + effectedRecordAmount);
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
