package com.vti.service;

import com.vti.entity.*;
import com.vti.entity.primarykey.ExamQuestionKey;
import com.vti.entity.primarykey.GroupAccountKey;
import com.vti.repository.IExamQuestionRepository;
import com.vti.repository.IGroupAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupAccountService implements IGroupAccountService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: GroupAccount
     */

    @Autowired
    private IGroupAccountRepository repository;

    // get all
    @Override
    public List<GroupAccount> getListGroupAccounts() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<GroupAccount> getAllGroupAccounts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public GroupAccount getGroupAccountById(GroupAccountKey id) {
        return repository.findGroupAccountById(id);
    }

    // get by group with @Query
    @Override
    public GroupAccount getGroupAccountByGroup(Group group) {
        return repository.findGroupAccountByGroup(group);
    }

    // get by account with @Query
    @Override
    public GroupAccount getGroupAccountByAccount(Account account) {
        return repository.findGroupAccountByAccount(account);
    }

    // create new
    @Override
    public void createGroupAccount(GroupAccount groupAccount) {
        repository.save(groupAccount);
    }

    // update find by id
    @Override
    public void updateGroupAccount1(GroupAccountKey id, Group newGroup, Account newAccount) {
        GroupAccount groupAccount = repository.findGroupAccountById(id);
        groupAccount.setGroup(newGroup);
        groupAccount.setAccount(newAccount);
    }

    // update by object
    @Override
    public void updateGroupAccount2(GroupAccount groupAccount) {
        repository.save(groupAccount);
    }

    // delete by id
    @Override
    public void deleteGroupAccount(GroupAccountKey id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isGroupAccountExistId(GroupAccountKey id) {
        return repository.existsById(id);
    }

    // exists by group
    @Override
    public boolean isGroupAccountExistGroup(Group group) {
        GroupAccount groupAccount = repository.findGroupAccountByGroup(group);
        return groupAccount != null;
        // return repository.findGroupAccountByGroup(group) != null; // cách viết ngắn gọn
    }

    // exists by account
    @Override
    public boolean isGroupAccountExistAccount(Account account) {
        GroupAccount groupAccount = repository.findGroupAccountByAccount(account);
        return groupAccount != null;
        // return repository.findGroupAccountByAccount(account) != null; // cách viết ngắn gọn
    }































}
