package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, IOException, SQLException {
		accountService = new AccountService();
	}

	// hàm lấy danh sách account
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException {
		List<Account> listAccounts = accountService.getListAccounts();
		return listAccounts;
	}

}
