package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.ultis.JdbcConnection;

public class EmployeeReponsitoryImpl implements IEmployeeReponsitory {

	@Override
	public List<Employee> printEmployeesByProjectId(int projectId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT id, full_name, email, password, project_id, pro_skill FROM User WHERE project_id = ? AND role = 'employee'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int projId = rs.getInt("project_id");
				String proSkill = rs.getString("pro_skill");
				Employee employee = new Employee(id, fullName, email, password, projId, proSkill);
				employees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(conn, null, pstmt, null, rs);
		}
		return employees;
	}
}
