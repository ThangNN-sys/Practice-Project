package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.jdbcUltis;

public class AccountRepository implements IAccountRepository {
	private jdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException, SQLException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException {
		// kết nối DB, lấy danh sách account
		String sqlSelect = "SELECT * FROM account";
		ResultSet resultSet = jdbc.executeQuery(sqlSelect);
		List<Account> listAccounts = new ArrayList();
		while (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setFullName(resultSet.getString(3));

			account.setLocalDate(resultSet.getDate(7).toLocalDate());
			listAccounts.add(account);
		}
		return listAccounts;
	}

}
