package com.vti.test;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.AccountRepository;

import java.util.List;

public class AccountTest {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();

        System.out.println("***********GET ALL ACCOUNTS***********");

        List<Account> Accounts = repository.getAllAccounts();

        for (Account account : Accounts) {
            Department department = account.getDepartment();
            System.out.println(department.getName());
            System.out.println(account.getFullName());
        }

        System.out.println("\n\n***********CREATE ACCOUNT***********");

//		Account accountCreate = new Account();
//		accountCreate.setUsername("NguyenVanA");
//		accountCreate.setEmail("NguyenVanA@gmail.com");
//		accountCreate.setFirstName("A");
//		accountCreate.setLastName("Nguyen Van");
//
//		repository.createAccount(accountCreate);

    }
}
