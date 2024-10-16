package com.vti.frontend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vti.ultis.JdbcConnection;

public class Q1_InsertData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// khởi tạo & nhập thông tin user có id từ 1 đến 11
		insertUser(1, "user1", "user1@gmail.com", "1234567", null, "dev", "project001", "employee");
		insertUser(2, "user2", "user2@gmail.com", "1234567", null, "test", "project001", "employee");
		insertUser(3, "user3", "user3@gmail.com", "1234567", null, "java", "project002", "employee");
		insertUser(4, "user4", "user4@gmail.com", "1234567", null, "sql", "project002", "employee");
		insertUser(5, "user5", "user5@gmail.com", "1234567", null, "dev", "project003", "employee");
		insertUser(6, "user6", "user6@gmail.com", "1234567", null, "dev", "project003", "employee");
		insertUser(7, "user7", "user7@gmail.com", "1234567", "5", "null", "project001", "manager");
		insertUser(8, "user8", "user8@gmail.com", "1234567", "2", "null", "project002", "manager");
		insertUser(9, "user9", "user9@gmail.com", "1234567", "6", "null", "project003", "manager");
		insertUser(10, "user10", "user10@gmail.com", "1234567", "8", "null", "project004", "manager");
		insertUser(11, "user11", "user11@gmail.com", "1234567", "1", "null", "project005", "manager");
	}

	public static void insertUser(int id, String full_name, String email, String password, String exp_in_year,
			String pro_skill, String project_id, String role) throws SQLException {
		Connection myConn = null;
		PreparedStatement pstmt = null;
		try {
			// gọi hàm getConnection để kết nối tới DB mysql
			myConn = JdbcConnection.getConnection();
			// khởi tạo cấu trúc nhập và câu lệnh thêm dữ liệu vào bảng user
			String sql = "INSERT INTO user (id, full_name, email, password, exp_in_year, pro_skill, project_id, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = myConn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, full_name);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, exp_in_year);
			pstmt.setString(6, pro_skill);
			pstmt.setString(7, project_id);
			pstmt.setString(8, role);
			int count = pstmt.executeUpdate();
			// kiểm tra việc thêm mới và thông báo nếu thêm thành công
			if (count > 0) {
				System.out.println("Thêm mới thành công.");
			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(myConn, pstmt, null, null);
		}
	}
}
