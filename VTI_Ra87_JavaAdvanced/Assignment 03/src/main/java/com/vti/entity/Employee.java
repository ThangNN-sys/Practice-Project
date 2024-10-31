package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Employee")
@PrimaryKeyJoinColumn(name = "AccountID") // 1-1 Relationship with Account.AccountID
public class Employee extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear; // Maps to TINYINT UNSIGNED NOT NULL

    public Employee() {
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workingNumberOfYear=" + workingNumberOfYear +
                '}';
    }
}
