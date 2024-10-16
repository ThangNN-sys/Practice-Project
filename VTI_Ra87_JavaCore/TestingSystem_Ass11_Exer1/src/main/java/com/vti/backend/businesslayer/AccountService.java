package com.vti.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.entiy.Account;

public class AccountService {

	private AccountRepository repository;

	public AccountService() throws IOException {
		repository = new AccountRepository();
	}

	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return repository.getListAccounts();
	}
}
