package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

public class AccountFunction {
	// Method hiển thị toàn bộ Account
	private AccountController accountController; // hàm để tạo mới accountController

	public AccountFunction() throws FileNotFoundException, IOException, SQLException {
		accountController = new AccountController(); // cách viết để tối ưu, khởi tạo accountController khi khởi tạo
														// AccountFunction
	}

	public void showAccount() throws ClassNotFoundException, SQLException {
		System.out.println("Hiển thị danh sách Account đang có trên DB:");
		// Cần 1 danh sách Account
		List<Account> listAccounts = accountController.getListAccounts(); // để lấy ra được list account
	}

	// Method hiển thị Account theo ID
	public void showAccountById() {

	}

}
