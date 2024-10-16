package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.EmployeeServiceImpl;
import com.vti.backend.businesslayer.IEmployeeService;
import com.vti.entity.Employee;

//Layer-1 (Presentation Layer): kiểm tra tính đúng đắn của dữ liệu nhận được từ frontend (App class)

public class EmployeeController {
	public IEmployeeService iuserservice;

	public EmployeeController() {
		iuserservice = new EmployeeServiceImpl();
	}

	public List<Employee> printEmployeesByProjectId(int projectId) throws SQLException {
		return iuserservice.printEmployeesByProjectId(projectId);
	}
}
