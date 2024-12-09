package com.vti.service;

import com.vti.entity.*;
import com.vti.entity.primarykey.GroupAccountKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupAccountService {

    List<GroupAccount> getListGroupAccounts();

    Page<GroupAccount> getAllGroupAccounts(Pageable pageable);

    GroupAccount getGroupAccountById(GroupAccountKey id);

    GroupAccount getGroupAccountByGroup(Group group);

    GroupAccount getGroupAccountByAccount(Account account);

    void createGroupAccount(GroupAccount groupAccount);

    void updateGroupAccount1(GroupAccountKey id, Group newGroup, Account newAccount);

    void updateGroupAccount2(GroupAccount groupAccount);

    void deleteGroupAccount(GroupAccountKey id);

    boolean isGroupAccountExistId(GroupAccountKey id);

    boolean isGroupAccountExistGroup(Group group);

    boolean isGroupAccountExistAccount(Account account);

}
