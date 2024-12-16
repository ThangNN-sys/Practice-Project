package com.vti.service;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService implements IAccountService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Account
     */

    @Autowired
    private final IAccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public AccountService(IAccountRepository repository) {
        this.repository = repository;
    }

    // get all
    @Override
    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    // get all paging
//    @Override
//    public Page<AccountDTO> getAllAccountsPaging(Pageable pageable) {
//        Page<Account> accounts = repository.findAll(pageable);
//        return accounts.map(account -> modelMapper.map(account, AccountDTO.class));
//    }

    // get all paging with nameSearch
    @Override
    public Page<AccountDTO> getAllAccountsPaging(Pageable pageable, String nameSearch) {
        Page<Account> accounts;
        if (nameSearch != null && !nameSearch.isEmpty()) {
            accounts = repository.findByNameContainingIgnoreCase(pageable, nameSearch);
        } else {
            accounts = repository.findAll(pageable);
        }
        return accounts.map(account -> modelMapper.map(account, AccountDTO.class));
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

    // exists by id
    @Override
    public boolean isAccountExistsId(short id) {
        return repository.existsById(id);
    }

    // exists by username
    @Override
    public boolean isAccountExistsUsername(String userName) {
        Account account = repository.findAccountByUsername(userName);
        return account != null;
        // return repository.findAccountByUsername(userName) != null; // cách viết ngắn gọn
    }


}
