package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository;

	public AccountService() throws FileNotFoundException, IOException, SQLException {
		super();
		accountRepository = new AccountRepository();
	}

	@Override
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException {
		List<Account> listAccounts = accountRepository.getListAccounts();
		return listAccounts;
	}

}
