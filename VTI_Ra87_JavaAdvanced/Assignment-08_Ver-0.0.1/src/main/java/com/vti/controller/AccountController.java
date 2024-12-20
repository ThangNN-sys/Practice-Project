package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Account
     */

    private final IAccountService service;

    public AccountController(IAccountService service) {
        this.service = service;
    }

    // get all list
//    @GetMapping()
//    public List<Account> getListAccount() {
//        return service.getListAccount();
//    }

    // get all paging with nameSearch
    @GetMapping()
    public ResponseEntity<Page<AccountDTO>> getAllAccounts(Pageable pageable, @RequestParam(value = "name-search") String nameSearch) {
        Page<AccountDTO> accounts = service.getAllAccountsPaging(pageable, nameSearch);
        return ResponseEntity.ok(accounts);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable(name = "id") short id) {
        return service.getAccountById(id);
    }

    // get by username
    @GetMapping(value = "/username/{name}")
    public Account getAccountByUsername(@PathVariable(name = "name") String name) {
        return service.getAccountByUsername(name);
    }

    // create new
    @PostMapping()
    public void createAccount(@RequestBody Account create) {
        service.createAccount(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateAccount1(@PathVariable(name = "id") short id, @RequestBody Account account) {
        account.setId(id);
        service.updateAccount1(id, account.getFirstName(), account.getLastName());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateAccount2(@RequestBody Account account) {
        service.updateAccount2(account);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable(name = "id") short id) {
        service.deleteAccount(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isAccountExistId(@PathVariable(name = "id") short id) {
        return service.isAccountExistsId(id);
    }

    // exists by username
    @GetMapping(value = "/exists-username/{name}")
    public boolean isAccountExistUsername(@PathVariable(name = "name") String name) {
        return service.isAccountExistsUsername(name);
    }

}
