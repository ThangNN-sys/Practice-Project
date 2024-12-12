package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.primarykey.GroupAccountKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupAccountService {

    List<GroupAccount> getAllGroupAccounts();

    Page<GroupAccount> getAllGroupAccountsPaging(Pageable pageable);

    GroupAccount getGroupAccountById(GroupAccountKey id);

    GroupAccount getGroupAccountByGroup(Group group);

    GroupAccount getGroupAccountByAccount(Account account);

    void createGroupAccount(GroupAccount groupAccount);

    void updateGroupAccount1(GroupAccountKey id, Group newGroup, Account newAccount);

    void updateGroupAccount2(GroupAccount groupAccount);

    void deleteGroupAccount(GroupAccountKey id);

    boolean isGroupAccountExistsId(GroupAccountKey id);

    boolean isGroupAccountExistsGroup(Group group);

    boolean isGroupAccountExistsAccount(Account account);

}
