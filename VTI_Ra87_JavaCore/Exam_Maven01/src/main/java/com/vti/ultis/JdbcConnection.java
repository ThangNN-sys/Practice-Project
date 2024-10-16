package com.vti.ultis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {
	public static Connection getConnection()
			throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection;
		connection = DriverManager.getConnection(url, username, password);
		if (connection != null) {
			System.out.println("Kết nối thành công!");
		} else {
			System.out.println("Kết nối không thành công.");
		}
		return connection;
	}

	public static void closeConnection(Connection connection, PreparedStatement pstmt, ResultSet rs)
			throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null && connection.isClosed()) {
			connection.close();
		}
	}
}
