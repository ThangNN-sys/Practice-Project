package com.vti.repository;

import com.vti.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Short> {

    @Query("SELECT v FROM Account v")
    List<Account> findAll();

    @Query("SELECT v FROM Account v WHERE v.id = :idParam")
    Account findAccountById(@Param("idParam") short id);

    @Query("SELECT v FROM Account v WHERE v.username = :nameParam")
    Account findAccountByUsername(@Param("nameParam") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Account v SET v.firstName = :firstNameParam, v.lastName = :lastNameParam WHERE v.id = :idParam")
    void updateAccount1(@Param("idParam") short id, @Param("firstNameParam") String firstName, @Param("lastNameParam") String lastName);

}
