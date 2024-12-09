package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.primarykey.GroupAccountKey;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGroupAccountRepository extends JpaRepository<GroupAccount, GroupAccountKey> {
    /**
     * Data Access Layer - Interface
     * Tương tác với cơ sở dữ liệu, thực hiện các truy vấn CRUD
     * Đối tượng: GroupAccount
     */

    @Query("SELECT v FROM GroupAccount v")
    List<GroupAccount> findAll();

    @Query("SELECT v FROM GroupAccount v WHERE v.id = :idParam")
    GroupAccount findGroupAccountById(@Param("idParam") GroupAccountKey id);

    @Query("SELECT v FROM GroupAccount v WHERE v.group = :groupParam")
    GroupAccount findGroupAccountByGroup(@Param("groupParam") Group group);

    @Query("SELECT v FROM GroupAccount v WHERE v.account = :accountParam")
    GroupAccount findGroupAccountByAccount(@Param("accountParam") Account account);

    @Modifying
    @Transactional
    @Query("UPDATE GroupAccount v SET v.group = :groupParam, v.account = :accountParam WHERE v.id = :idParam")
    void updateGroupAccount1(@Param("idParam") GroupAccountKey id, @Param("groupParam") Group group, @Param("accountParam") Account account);

}
