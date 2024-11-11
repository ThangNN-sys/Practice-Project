package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Employee của DB
 */

@Entity
@Table(name = "Employee", catalog = "TestingSystem")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "WorkingNumberOfYear", nullable = false)
	private short workingNumberOfYear;

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
		System.out.println("--------------------");
		System.out.println(super.toString());
		return "Employee [WorkingNumberOfYear=" + workingNumberOfYear + "]";
	}

}
