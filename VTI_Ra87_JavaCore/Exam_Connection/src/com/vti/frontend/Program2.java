package com.vti.frontend;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vti.ultis.JdbcConnection;

public class Program2 {
	public static void main(String[] args) throws SQLException {

//	String url = "jdbc:mysql://127.0.0.1:3306/testing_system";
//		String url = "jdbc:mysql://localhost:3306/railway87";
//		String username = "root";
//		String password = "root";
//
//		Connection myConn;
//		try {
//			myConn = DriverManager.getConnection(url, username, password);
//			if (myConn != null) {
//				System.out.println("�?ã được kết nối");
//				String sql = "insert into users (username, password)" + "values (?, ?)";
//				PreparedStatement preparedStatement = myConn.prepareStatement(sql);
//				preparedStatement.setString(1, "USER01");
//				preparedStatement.setString(2, "1234");
//				int effectedRecordAmount = preparedStatement.executeUpdate();
//				System.out.println("Số bản ghi đã được thêm vào: " + effectedRecordAmount);
//				myConn.close();
//
//			} else {
//				System.out.println("Không kết nối được");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String sql = "update user " + "set username = ?" + "set password = ?" + "where id = ?";
		PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, "USER001");
		preparedStatement.setString(2, "123456");
		int effectedRecordAmount = preparedStatement.executeUpdate();
		System.out.println("Số bản ghi đã được cập nhật: " + effectedRecordAmount);

	}
}
