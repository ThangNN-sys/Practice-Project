package com.vti.service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Address
     */

    @Autowired
    private IAccountRepository repository;

    // get all
    @Override
    public List<Account> getListAccounts() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Account getAccountById(short id) {
        return repository.findAccountById(id);
    }

    // get by username with @Query
    @Override
    public Account getAccountByUsername(String userName) {
        return repository.findAccountByUsername(userName);
    }

    // create new
    @Override
    public void createAccount(Account account) {
        repository.save(account);
    }

    // update name find by id
    @Override
    public void updateAccount1(short id, String newFirstName, String newLastName) {
        repository.updateAccount1(id, newFirstName, newLastName);
    }

    // update by object
    @Override
    public void updateAccount2(Account account) {
        repository.save(account);
    }

    // delete by id
    @Override
    public void deleteAccount(short id) {
repository.deleteById(id);
    }

    @Override
    public boolean isAccountExistId(short id) {
        return repository.existsById(id);
    }

    @Override
    public boolean isAccountExistUsername(String userName) {
        Account account = repository.findAccountByUsername(userName);
        return account != null;
        // return repository.findAccountByUsername(userName) != null; // cách viết ngắn gọn
    }

























    // exists by id


    // exists by name


}
