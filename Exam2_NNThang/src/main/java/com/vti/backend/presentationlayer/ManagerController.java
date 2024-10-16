package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IManagerService;
import com.vti.backend.businesslayer.ManagerServiceImpl;
import com.vti.entity.Manager;

//Layer-1 (Presentation Layer): kiểm tra tính đúng đắn của dữ liệu nhận được từ frontend (App class)

public class ManagerController {
	public IManagerService imanagerservice;

	public ManagerController() {
		imanagerservice = new ManagerServiceImpl();
	}

	public List<Manager> getAllManagers() throws SQLException {
		return imanagerservice.getAllManagers();
	}

}
