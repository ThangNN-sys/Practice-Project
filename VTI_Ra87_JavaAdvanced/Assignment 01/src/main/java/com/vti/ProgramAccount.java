package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class ProgramAccount {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

		System.out.println("***********GET ALL ACCOUNTS***********");

		List<Account> accounts = repository.getAllAccounts();

		for (Account account : accounts) {
			System.out.println(account);
		}

//		System.out.println("\n\n***********GET ACCOUNT BY ID***********");
//
//		Account accountById = repository.getAccountByID((short) 3);
//		System.out.println(accountById);
//
//		System.out.println("\n\n***********GET ACCOUNT BY USERNAME***********");
//
//		Account accountByUserName = repository.getAccountByUserName("...");
//		System.out.println(accountByUserName);
//
//		System.out.println("\n\n***********CREATE ACCOUNT***********");
//
//		Account accountCreate = new Account();
//		accountCreate.setUsername("Marketing");
//		repository.createAccount(accountCreate);

	}
}
