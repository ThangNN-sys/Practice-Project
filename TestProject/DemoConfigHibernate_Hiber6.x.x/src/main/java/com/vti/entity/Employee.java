package com.vti.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Employee", catalog = "TestingSystem")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short WorkingNumberOfYear;

    public Employee() {
    }

    public short getWorkingNumberOfYear() {
        return WorkingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        WorkingNumberOfYear = workingNumberOfYear;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Employee [WorkingNumberOfYear=" + WorkingNumberOfYear + "]";
    }

}
