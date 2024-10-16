package com.vti.frontend;

import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entiy.Account;

public class Program {

	public static void main(String[] args) throws Exception {
		AccountController accountController = new AccountController();

		List<Account> accounts = accountController.getListAccounts();

		for (Account account : accounts) {
			System.out.println(account);
		}
	}
}
