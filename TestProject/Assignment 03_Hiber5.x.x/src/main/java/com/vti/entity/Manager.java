package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Manager")
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
