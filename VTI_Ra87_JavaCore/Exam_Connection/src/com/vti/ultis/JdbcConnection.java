package com.vti.ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/railway87";
		String username = "root";
		String passowrd = "root";
		Connection myConn = DriverManager.getConnection(url, username, passowrd);
		if (myConn != null) {
			System.out.println("Connection oki");
		} else {

			System.out.println("Connection error");
		}

		return myConn;
	}

	public static void closeConnection(Connection myConn, PreparedStatement pstmt, Statement stm, ResultSet rs)
			throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (stm != null) {
			stm.close();
		}
		if (myConn != null && !myConn.isClosed()) {
			myConn.close();

		}
	}

	public static void viewUserById(String idTmp) throws SQLException {
		Connection myConn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			myConn = JdbcConnection.getConnection();
			if (myConn != null) {
				st = myConn.createStatement();
				String sql = "select * from users where id = " + idTmp;

				rs = st.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String us = rs.getString("username");
					System.out.println("User:" + id + "  " + us);
				}

			} else {
				System.out.println("Connection error");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(myConn, null, st, rs);
		}

	}

}
