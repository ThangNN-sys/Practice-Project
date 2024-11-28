package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Manager")
public class Manager implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AccountID", nullable = false)
    private short accountId; // TINYINT UNSIGNED

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short managementNumberOfYear; // TINYINT UNSIGNED

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID", nullable = false)
    private Account account;

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountID) {
        this.accountId = accountID;
    }

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        this.managementNumberOfYear = managementNumberOfYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "accountID=" + accountId +
                ", managementNumberOfYear=" + managementNumberOfYear +
                ", account=" + account +
                '}';
    }
}
