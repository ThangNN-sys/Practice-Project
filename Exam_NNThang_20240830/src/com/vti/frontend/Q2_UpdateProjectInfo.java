package com.vti.frontend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.ultis.JdbcConnection;

public class Q2_UpdateProjectInfo {
	public static void main(String[] args) throws SQLException {
		update_project("pro003");
	}

	public static void update_project(String project_id) throws SQLException {
		System.out.println("Update ID Project:");
		System.out.println("Chọn user cần update (nhập user id):");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Connection myConn = null;
		PreparedStatement pstmt1 = null;
		myConn = JdbcConnection.getConnection();
		String sql = "UPDATE project_id SET project_id = ? WHERE (id = ?)";
		pstmt1 = myConn.prepareStatement(sql);
		pstmt1.setString(1, project_id);
		pstmt1.setInt(2, id);
		if (pstmt1.executeUpdate() == 1) {
			System.out.println("Update thành công.");
		} else {
			System.out.println("Update không thành công");
		}
		myConn.close();
	}
}
