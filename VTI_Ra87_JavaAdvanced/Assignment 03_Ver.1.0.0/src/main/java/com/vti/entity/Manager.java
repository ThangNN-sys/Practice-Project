package com.vti.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Manager", catalog = "TestingSystem")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ManagementNumberOfYear", nullable = false)
	private short ManagementNumberOfYear;

	public Manager() {
	}

	public short getManagementNumberOfYear() {
		return ManagementNumberOfYear;
	}

	public void setManagementNumberOfYear(short managementNumberOfYear) {
		ManagementNumberOfYear = managementNumberOfYear;
	}

	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Manager [ManagementNumberOfYear=" + ManagementNumberOfYear + "]";
	}
}
