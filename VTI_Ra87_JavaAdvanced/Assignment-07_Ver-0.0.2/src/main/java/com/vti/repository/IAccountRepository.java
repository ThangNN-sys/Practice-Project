package com.vti.repository;

import com.vti.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Short> {

    @Query("SELECT a FROM Account a")
    List<Account> findAll();

    @Query("SELECT a FROM Account a WHERE a.accountId = :idParam")
    Account findAccountById(@Param("idParam") short id);

    @Query("SELECT a FROM Account a WHERE a.username = :nameParam")
    Account findAccountByUsername(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.firstName = :firstNameParam, a.lastName = :lastNameParam WHERE a.accountId = :idParam")
    void updateAccount1(@Param("idParam") short id, @Param("firstNameParam") String firstName, @Param("lastNameParam") String lastName);

}
