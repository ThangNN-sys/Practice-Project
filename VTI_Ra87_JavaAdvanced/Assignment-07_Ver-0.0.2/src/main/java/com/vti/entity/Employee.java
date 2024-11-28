package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AccountID", nullable = false)
    private short accountId; // TINYINT UNSIGNED

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear; // TINYINT UNSIGNED

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID", nullable = false)
    private Account account;

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountID) {
        this.accountId = accountID;
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
