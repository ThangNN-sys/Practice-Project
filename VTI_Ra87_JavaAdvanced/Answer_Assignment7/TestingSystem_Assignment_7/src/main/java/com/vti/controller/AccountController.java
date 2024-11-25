package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping()
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountService.getAllAccounts(pageable);
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable(name = "id") short id) {
        return accountService.getAccountByID(id);
    }

    @GetMapping(value = "/name")
    public Account getAccountByName(@RequestParam(name = "name") String name) {
        return accountService.getAccountByName(name);
    }

    @PostMapping()
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping(value = "/{id}")
    public void updateAccount(@PathVariable(name = "id") short id, @RequestBody Account account) {
        account.setAccountId(id);
        accountService.updateAccount(account);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable(name = "id") short id) {
        accountService.deleteAccount(id);
    }
}
