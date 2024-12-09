package com.vti.service;

import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {

    List<Account> getListAccounts();

    Page<Account> getAllAccounts(Pageable pageable);

    Account getAccountById(short id);

    Account getAccountByUsername(String userName);

    void createAccount(Account account);

    void updateAccount1(short id, String newFirstName, String newLastName);

    void updateAccount2(Account account);

    void deleteAccount(short id);

    boolean isAccountExistId(short id);

    boolean isAccountExistUsername(String userName);

}
