package com.vti.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUltis {
	private Properties property;
	private Connection connection;

	public jdbcUltis() throws SQLException, IOException {
		property = new Properties();
		property.load(new FileInputStream(
				"D:\\VTI Academy\\Railway87_Thang_Project\\VTI_Rail63_Ass11_DBconnect_3Layers\\src\\com\\vti\\resources"));
	}

// Phương thức kiểm tra kết nối tới DB
	public void connectionTesting() throws ClassNotFoundException, SQLException {
		String url = property.getProperty("url"); // jdbc:mysql://localhost:3306/TestingSystem?autoReconnect=true&useSSL=false&characterEncoding=latin1
		String username = property.getProperty("username"); // root
		String password = property.getProperty("password"); // root
		String driver = property.getProperty("driver"); // com.mysql.cj.jdbc.Driver
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password); // Tạo kết nối tới DB -> 1. thành công
																			// 2. Không thành công -> Exception (Complie
																			// time)
		System.out.println("Connection Success");
	}

// Phương thức tạo kết nối tới DB
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		String driver = property.getProperty("driver");
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	public void disConnection() throws SQLException {
		connection.close();
	}

	public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		return result;
	}

	public PreparedStatement createPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
	}
}
