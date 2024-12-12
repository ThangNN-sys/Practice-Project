package com.vti.service;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {

    List<Account> getAllAccounts();

    Page<AccountDTO> getAllAccountsPaging(Pageable pageable);

    Account getAccountById(short id);

    Account getAccountByUsername(String userName);

    void createAccount(Account account);

    void updateAccount1(short id, String newFirstName, String newLastName);

    void updateAccount2(Account account);

    void deleteAccount(short id);

    boolean isAccountExistsId(short id);

    boolean isAccountExistsUsername(String userName);

}
