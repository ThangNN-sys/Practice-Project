package com.vti.entity;

import com.vti.entity.enumerate.SalaryName;
import com.vti.entity.enumerate.SalaryNameConvert;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Salary của DB
 */

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryId; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

	@Column(name = "SalaryName", nullable = false, unique = true)
	@Convert(converter = SalaryNameConvert.class)
	private SalaryName salaryName; // maps to ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY

//	@OneToMany(mappedBy = "salary")
//	private List<Account> accounts;

	public Salary() {
	}

	public short getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(short id) {
		this.salaryId = id;
	}

	public SalaryName getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(SalaryName name) {
		this.salaryName = name;
	}

//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Salary { " + "ID = " + salaryId + ", Name = '" + salaryName.getValue() + '\'' + '}';
	}

}
