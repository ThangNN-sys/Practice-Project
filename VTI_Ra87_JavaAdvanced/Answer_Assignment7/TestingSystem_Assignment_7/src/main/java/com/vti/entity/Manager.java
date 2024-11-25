package com.vti.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Manager")
@PrimaryKeyJoinColumn(name = "AccountID")
@Setter
@Getter
public class Manager extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short managementNumberOfYear;

    public Manager() {
    }

//	/**
//	 * @return the managementNumberOfYear
//	 */
//	public short getManagementNumberOfYear() {
//		return managementNumberOfYear;
//	}
//
//	/**
//	 * @param managementNumberOfYear the managementNumberOfYear to set
//	 */
//	public void setManagementNumberOfYear(short managementNumberOfYear) {
//		this.managementNumberOfYear = managementNumberOfYear;
//	}

    @Override
    public String toString() {
        return "Manager [managementNumberOfYear=" + managementNumberOfYear
                + ", getAccountId()=" + getAccountId() + ", getEmail()=" + getEmail() + ", getUsername()="
                + getUsername() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
                + ", getFullName()=" + getFullName() + ", getCreateDate()=" + getCreateDate() + ", getDepartment()="
                + getDepartment() + ", getPosition()=" + getPosition() + ", getSalary()=" + getSalary() + "]";
    }

}
